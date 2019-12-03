package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DungeonGame {
/*

    private Maze maze;

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
    }

    private void startGame() {
        System.out.println("--- Loading map ---");

        this.maze = new Maze();
        this.hero = new Hero();

        hero.setPosition(1, 14);

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Where do you want to go " + hero.name + "? ---");
        System.out.println(
                "1. Up" + "\n" +
                        "2. Down" + "\n" +
                        "3. Left" + "\n" +
                        "4. Right"
        );

        int whereoTo = scanner.nextInt();

        switch (whereoTo) {
            case 1:
                hero.setYPosition(yPostion - 1);
                enterRoom();
                break;
            case 2:
                hero.setYPosition(yPosition + 1);
                break;
            case 3:
                hero.setXPosition(xPosition - 1);
                break;
            case 4:
                hero.setXPosition(xPosition + 1);
                break;

        }
    }

    private void enterRoom() {
        if (maze.getMazeRoom(hero.xPosition, hero.yPosition).MONSTER) {
            fight();

        } else if (maze.getMazeRoom(hero.xPosition, hero.yPosition).TREASURE) {
            treasure();

        } else if (maze.getMazeRoom(hero.xPosition, hero.yPosition).EMPTY) {
            empty();

        } else if (maze.getMazeRoom(hero.xPosition, hero.yPosition)..BOSS){
            bossFight();

        }

    }

    private void bossFight() {
        System.out.println(hero + "encountered the boss!");
    }

    private void empty() {
        System.out.println("This room is empty..");
    }

    private void fight() {
        System.out.println(hero + "encountered" + maze.getMazeArray()[hero.getXposition][hero.getYposition].MONSTER);

        System.out.println("1. Fight \n" +
                "2. Flee \n" +
                "3. Random action");
        Scanner scanner = new Scanner(System.in);
        int whatToDO = scanner.nextInt();

        switch (whatToDO) {
            case 1:
                System.out.println("A fight broke out!");
                break;
            case 2:
                System.out.println("You tried to flee");
                break;
            case 3:
                System.out.println("Some random action");
                break;
        }

    }

    private void treasure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You found a treasure!");
        int randomNum = ThreadLocalRandom.current().nextInt(0, itemArray.length);
        System.out.println("You found " + itemArray[randomNum] + "\n" +
                "Do you want to pick up item? Y / N? ");

        String input = scanner.nextLine();
        if (input.toLowerCase() == "y") {
            hero.addItem(itemArray[randomNum]);
            System.out.println("Picked up item");
        }
        else if (input.toLowerCase() == "n") {
            System.out.println("Left item");
        }
        else {
            System.out.println("You fucked up. " + "Lost 2 HP for being stupid ");
            hero.setHealth(-2);
        }
    }

 */
}
/* * */