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

        System.out.println(
                "1. Start game " + "\n" +
                        "2. Load game " + "\n" +
                        "3. Exit game " + "\n");

        int choice = scanner.nextInt();

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

    }

    private void exitGame() {
        System.out.println("--- You exited the game ---");
        this.exitGame = true;
    }

    private void startGame() {

        this.hero = new Hero("pelle");
        System.out.println( "Hero " + hero.getName() + " created");
        this.maze = new Maze();

        System.out.println("--- Loading map ---");

        System.out.println("--- You entered the Dungeon ---");

        movement();
    }

    private void movement() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMap();
            System.out.println("--- Where do you want to go " + hero.getName() + "? ---");
            System.out.println(
                    "1. Up" + "\n" +
                            "2. Down" + "\n" +
                            "3. Left" + "\n" +
                            "4. Right");

            int whereoTo = scanner.nextInt();

            switch (whereoTo) {
                case 1:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() - 1)) {
                        hero.setPosition(hero.getPositionX(), hero.getPositionY() - 1);
                        enterRoom();
                    }
                    break;
                case 2:
                    if (maze.canIgoHere(hero.getPositionX(), hero.getPositionY() + 1)) {
                        hero.setPosition(hero.getPositionX(), hero.getPositionY() + 1);
                        enterRoom();
                    }
                    break;
                case 3:
                    if (maze.canIgoHere(hero.getPositionX() - 1, hero.getPositionY())) {
                        hero.setPosition(hero.getPositionX() - 1, hero.getPositionY());
                        enterRoom();
                    }
                    break;
                case 4:
                    if (maze.canIgoHere(hero.getPositionX() + 1, hero.getPositionY())) {
                        hero.setPosition(hero.getPositionX() + 1, hero.getPositionY());
                        enterRoom();
                    }
                    break;
            }
        }
    }

    public void showMap() {
        System.out.println(maze);
    }

    private void enterRoom() {
        if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getMonster() != null) { // finns det monster?
            fight();

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getRoomItems() != null) { // finns det kista?
            treasure();

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getIsEmpty()) { // är det tomt?
            empty();

        } else if (maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).isBossRoom()) { // är det bossen?
            boss();

        }

    }

    private void boss() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(hero + "encountered The Elder Dragon!");
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
            if (scanner.nextLine().toLowerCase() == "y") {
                if (keydropped < 1) {
                    //dropToothbrushSomewhereInDungeon();
                    keydropped++;
                } else if (scanner.nextLine().toLowerCase() == "y" && keydropped >= 1) {
                    System.out.println("You have already taken upon you to complete the dragons quest");
                } else {
                    System.out.println("You angered The Elder Dragon and she blasted you with a ball of fire");
                    hero.setHealth(0);
                }
            }
        }
    }

    //Ta bort senare
    /*
    private void dropToothbrushSomewhereInDungeon() {

        boolean cont = true;
        do {
            int randomNum = ThreadLocalRandom.current().nextInt(0, maze.getMazeArray().length + 1);

            if (!maze.getMazeRoom(randomNum, randomNum).getWall()) {
                maze.getMazeArray()[randomNum][randomNum].placeToothbrushRoom();
                cont = false;
            }
        } while (cont);
    }
    */

    private void empty() {
        System.out.println("This room is empty..");
    }

    private void fight() {
        System.out.println(hero + "encountered" + maze.getMazeRoom(hero.getPositionX(), hero.getPositionY()).getMonster()); // + MONSTER

        while(true) {
            System.out.println("1. Fight \n" +
                    "2. Flee \n" +
                    "3. Heal up");
            Scanner scanner = new Scanner(System.in);
            int whatToDO = scanner.nextInt();

            switch (whatToDO) {
                case 1:
                    System.out.println("A fight broke out!");
                    //hero.attackEnemy();
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
        if (input.toLowerCase() == "y") {

            /*int gold = maze.getMazeRoom(hero.getPositionX(), hero.getPositionY().());
            hero.addGold(gold);
*/
            System.out.println("Picked up gold " + "gold");
        } else if (input.toLowerCase() == "n") {
            System.out.println("Left item");
        } else {
            System.out.println("You fucked up. " + "Lost 2 HP for being stupid ");
            hero.setHealth(-2);
        }
    }

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
    }
}