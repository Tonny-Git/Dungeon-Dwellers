package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DungeonGame implements Serializable {

    private Maze maze;
    private Hero hero;
    private boolean exitGame = false;
    private int keydropped = 0;
    private DungeonGame game;
    private int lastKnownHeroPosX;
    private int lastKnownHeroPosY;


    public DungeonGame() {
        mainMenu();

    }

    public void setSaveGame(DungeonGame game) {
        this.game = game;

    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Welcome to Dungeon Dwellers ----");
        int choice;

        while (true) {
            System.out.println("1. Start game " + "\n" +
                            "2. Load game " + "\n" +
                            "3. Exit game " + "\n");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Can only input numbers, please try again!");
                continue;
            }

            if (choice > 0 && choice <= 3) {
                break;
            } else {
                System.out.println("Number is out of bound, please try again!");
            }

        }

        switch (choice) {

            case 1:
                startGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
                exitGame();
                break;
        }
    }

    private void loadGame() {
        System.out.println("Not implemented in beta. Wait for future updates");
        mainMenu();
    }

    private void exitGame() {
        saveGame(this.game);
        System.out.println("--- You exited the game ---");
        exitGame = true;
    }

    private void startGame() {
        System.out.println("Enter your heros name: ");
        Scanner scanner = new Scanner(System.in);
        String heroName = scanner.nextLine();
        this.hero = new Hero(heroName);
        System.out.println("Hero " + hero.getName() + " created");
        this.maze = new Maze();

        System.out.println("--- Loading map ---");

        System.out.println("--- You entered the Dungeon ---");

        updateHeroPosition(1, 1);
        movement();
    }

    private void movement() {

        Scanner scanner = new Scanner(System.in);

        while (!exitGame) {
            showMap();

            int whereTo;
            try {
                System.out.println("--- Where do you want to go " + hero.getName() + "? ---");
                System.out.println("1. Up" + "\n" +
                                "2. Down" + "\n" +
                                "3. Left" + "\n" +
                                "4. Right" + "\n" +
                                "5. Save and exit");
                whereTo = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Can only input numbers, please try again!");
                System.out.println("Press enter to continue. . .");
                scanner.nextLine();
                continue;
            }
            if (whereTo < 1 || whereTo > 5) {
                System.out.println("Number is out of bound, please try again!");
                System.out.println("Press enter to continue. . .");
                scanner.nextLine();
                continue;
            }

            switch (whereTo) {
                case 1:
                    if (maze.canIgoHere(hero.getPositionX() - 1, hero.getPositionY())) {
                        setlastKnownHeroPos(hero.getPositionX(),hero.getPositionY());
                        updateHeroPosition(hero.getPositionX() - 1, hero.getPositionY());
                        enterRoom();
                    }
                    break;
                case 2:
                    if (maze.canIgoHere(hero.getPositionX() + 1, hero.getPositionY())) {
                        setlastKnownHeroPos(hero.getPositionX(),hero.getPositionY());
                        updateHeroPosition(hero.getPositionX() + 1, hero.getPositionY());
                        enterRoom();
                    }
                    break;
                case 3:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() - 1)) {
                        setlastKnownHeroPos(hero.getPositionX(),hero.getPositionY());
                        updateHeroPosition(hero.getPositionX(), hero.getPositionY() - 1);
                        enterRoom();
                    }
                    break;
                case 4:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() + 1)) {
                        setlastKnownHeroPos(hero.getPositionX(),hero.getPositionY());
                        updateHeroPosition(hero.getPositionX(), hero.getPositionY() + 1);
                        enterRoom();
                    }
                    break;
                case 5:
                    exitGame();
            }
        }
    }

    public void showMap() {
        System.out.print(maze);
    }

    private void enterRoom() {
        if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).isBossRoom()) { // är det bossen?
            boss();
        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getIsEmpty()) { // är det tomt?
            empty();
        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getMonster() != null) { // finns det monster?
            fight();
        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getRoomItems() != null) { // finns det kista?
            treasure();
        }
    }


    private void boss() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(hero.getName() + " encountered The Elder Dragon!");
        if (hero.getTotalExp() >= 500 && hero.hasToothbrush()) {
            System.out.println(
                    "You gave the dragon her toothbrush" + "\n" +
                            "You got rewarded with the biggest chest you'd seen");
            exitGame();
        } else {
            System.out.println(
                    "You met a dragon. She has a quest for you." + "\n" +
                            "She wants you to find her toothbrush that's been lost in this dungeon." + "\n" +
                            "IF you retrieve it for her she will reward you greatly." + "\n" +
                            "Do you accept? Y/N");
            if (input.toLowerCase().equals("y")) {
                if (keydropped < 1) {
                    //dropToothbrushSomewhereInDungeon();
                    keydropped++;
                } else if (input.toLowerCase().equals("y") && keydropped >= 1) {
                    System.out.println("You have already taken upon you to complete the dragons quest");
                } else {
                    System.out.println("You angered The Elder Dragon and she blasted you with a ball of fire");
                    hero.setHealth(0);
                }
            }
        }
    }
/*
    private void dropToothbrushSomewhereInDungeon() {
        boolean cont = false;
        do {

            int randomNum = ThreadLocalRandom.current().nextInt(0, maze.getMazeArray().length);

            if (!maze.getMazeRoom(randomNum, randomNum).getWall()) {
                maze.getMazeArray()[randomNum][randomNum].placeToothbrushRoom();
                cont = true;
            }
        } while (!cont);
    }
*/
    private void empty() {
        System.out.println("This room is empty..");
    }

    private void fight() {
        boolean fightActive = true;
        Monster monsterInRoom = maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getMonster();
        System.out.println(hero.getName() + " encountered " + monsterInRoom.getName());

        while (fightActive) {
            System.out.println("1. Fight \n" +
                    "2. Flee \n" +
                    "3. Heal up");
            Scanner scanner = new Scanner(System.in);
            int whatToDO = scanner.nextInt();

            switch (whatToDO) {
                case 1:
                    hero.attackEnemy(monsterInRoom);
                    if (monsterInRoom.getHealth() <= 0) {
                        hero.gainedExperiencePoints(monsterInRoom.getExperiencePoints());
                        maze.getMazeRoom(hero.getPositionX(),hero.getPositionY()).setEmpty(true);
                        fightActive = false;
                    } else {
                        monsterInRoom.attackEnemy(hero);
                    }
                    break;
                case 2:
                    System.out.println("You fled back to the room you came from.");
                    updateHeroPosition(this.lastKnownHeroPosX,this.lastKnownHeroPosY);
                    movement();
                    break;
                case 3:
                    ArrayList<Items> itemsInBackpack = hero.getBackpack().getItemsInBackpack();

                    int index = 0;

                    for (Items item: itemsInBackpack) {
                        index++;
                        System.out.println(index + "." + item + "\n");
                    }
                    System.out.println("Which item do you want to use?");
                    int backpackUsage = scanner.nextInt();
                    hero.getBackpack().getItemsInBackpack().get(backpackUsage).useItem();
                    }
                    System.out.println("You healed up to " + hero.getHealth());
                    break;
            }
        }

    private void treasure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You found a treasure!");

        String item = maze.getMazeRoom(hero.getPositionX(),hero.getPositionY()).getRoomItems().getName();

        System.out.println("You found " + item + "\n" +
                "Do you want to pick up item? Y / N? ");


        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            System.out.println("Picked up item: " + item );
            maze.getMazeRoom(hero.getPositionX(),hero.getPositionY()).setEmpty(true);
        } else if (input.toLowerCase().equals("n")) {
            System.out.println("Left item");
        } else {
            System.out.println("You fucked up. " + "Lost 2 HP for being stupid ");
            hero.setHealth(hero.getHealth()-2);
            System.out.println("You now have " + hero.getHealth() + "Hp.");
        }
    }

    private void updateHeroPosition(int x, int y) {
        hero.setPosition(x, y);
        maze.updateHeroPosition(x, y);
    }
    private void setlastKnownHeroPos(int x, int y) {
        this.lastKnownHeroPosX = x;
        this.lastKnownHeroPosY = y;
    }


    private static void saveGame(Object object) {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("dungeonDweller.dat", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}