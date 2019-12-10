package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DungeonGame {

    private Maze maze;
    private Hero hero;
    private boolean exitGame = false;
    private int keydropped = 0;

    public DungeonGame() {
        mainMenu();

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
                exitGame = true;
                break;
        }
    }

    private void loadGame() {

    }

    private void exitGame() {
        System.out.println("--- You exited the game ---");
        exitGame = true;
    }

    private void startGame() {

        this.hero = new Hero("pelle");
        System.out.println("Hero " + hero.getName() + " created");
        this.maze = new Maze();

        System.out.println("--- Loading map ---");

        System.out.println("--- You entered the Dungeon ---");

        updateHeroPosition(7, 7);
        movement();
    }

    private void movement() {

        Scanner scanner = new Scanner(System.in);

        while (!exitGame) {
            showMap();
            System.out.println("--- Where do you want to go " + hero.getName() + "? ---");
            System.out.println(
                    "1. Up" + "\n" +
                            "2. Down" + "\n" +
                            "3. Left" + "\n" +
                            "4. Right" + "\n" +
                            "5. Save and exit");

            int whereTo = scanner.nextInt();

            switch (whereTo) {
                case 1:
                    if (maze.canIgoHere(hero.getPositionX() - 1, hero.getPositionY())) {
                        updateHeroPosition(hero.getPositionX() - 1, hero.getPositionY());
                        //hero.setPosition(hero.getPositionX(), hero.getPositionY() - 1);
                        enterRoom();
                    }
                    break;
                case 2:
                    if (maze.canIgoHere(hero.getPositionX() + 1, hero.getPositionY())) {
                        updateHeroPosition(hero.getPositionX() + 1, hero.getPositionY());
                        enterRoom();
                    }
                    break;
                case 3:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() - 1)) {
                        updateHeroPosition(hero.getPositionX(), hero.getPositionY() - 1);
                        enterRoom();
                    }
                    break;
                case 4:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() + 1)) {
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

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getMonster() != null) { // finns det monster?
            fight();

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getRoomItems() != null) { // finns det kista?
            treasure();

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getIsEmpty()) { // är det tomt?
            empty();

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
                    dropToothbrushSomewhereInDungeon();
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

    //Ta bort senare

    private void dropToothbrushSomewhereInDungeon() {
        boolean cont = false;
        do {

            int randomNum = ThreadLocalRandom.current().nextInt(0, maze.getMazeArray().length);

            if (!maze.getMazeRoom(randomNum, randomNum).getWall()) {
                maze.getMazeArray()[randomNum][randomNum].placeToothbrushRoom();
                cont = true;
            }
        } while(!cont);
    }

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
                        fightActive = false;
                    }
                    break;
                case 2:
                    System.out.println("You tried to flee. " + "It didn't work.");
                    break;
                case 3:
                    /// metod for use item
                    System.out.println("You healed"); // + hp regen
                    break;
            }
        }
    }

    private void treasure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You found a treasure!");


        int randomNum = ThreadLocalRandom.current().nextInt(0, 50);
        System.out.println("You found " + randomNum + " gold " + "\n" +
                "Do you want to pick up gold? Y / N?");

        // Slumpa ett item

       /* int randomNum = ThreadLocalRandom.current().nextInt(0, itemArray.length + 1);
        System.out.println("You found " + itemArray[randomNum] + "\n" +
                "Do you want to pick up item? Y / N? ");
*/

        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {

            /*int gold = maze.getMazeRoom(hero.getPositionX(), hero.getPositionY().());
            hero.addGold(gold);
*/
            System.out.println("Picked up gold " + "gold");
        } else if (input.toLowerCase().equals("n")) {
            System.out.println("Left gold");
        } else {
            System.out.println("You fucked up. " + "Lost 2 HP for being stupid ");
            hero.setHealth(-2);
            System.out.println("You now have " + hero.getHealth() + "Hp.");
        }
    }

    private void updateHeroPosition(int x, int y) {
        hero.setPosition(x, y);
        maze.updateHeroPosition(x, y);
    }
/*
    @Override
    public String toString() {
        String outputString = "";


        for (int i = 0; i < maze.getMazeArray().length; i++) {
            for (int j = 0; j < maze.getMazeArray()[i].length; j++) {
                if (i == hero.getPositionX() && j == hero.getPositionY()) {
                    outputString += "H";
                } else {
                    outputString += " " + maze.getMazeArray()[i][j];
                }
            }
        }
        return outputString;
    } */
}