package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Maze {

    private int mapSize = 10;
    private Room[][] mazeArray;
    private int[] mazePositions;
    private int heroPositionX = 0;
    private int heroPositionY = 0;


    public Maze() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
        int scannerInput = scanner.nextInt();

        if (scannerInput > 0 && scannerInput < 40) {
            this.mapSize = scannerInput;
        }

        mazePositions = new int[mapSize * mapSize];
        randomPosition();
        mazeArray = new Room[mapSize][mapSize];
        System.out.println(mazePositions);
        createMap();

    }

    public Room getMazeRoom(int xPosition, int yPosition) {

        return mazeArray[xPosition][yPosition];

    }

    public Room[][] getMazeArray() {
        return this.mazeArray;
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    /*private int[] makeWalls() {

        // 1 == wall
        // 0 == empty

        int wallCounter = 0;
        int[] wallArray = new int[mapSize * mapSize];

        for (int y = 0; y < wallArray.length; y++) {
            int randomNum = randomWithRange(0, 1);
            wallArray[y] = randomNum;
        }

        for (int i = 0; i < wallArray.length; i++) {
            if (i < mapSize || i >= wallArray.length - mapSize || i % mapSize == mapSize - 1 || i % mapSize == 0) {
                wallArray[i] = 1;
            } else {
                if (wallArray[i + 1] == 1) {
                    wallCounter++;
                }
                if (wallArray[i - 1] == 1) {
                    wallCounter++;
                }
                if (wallArray[i + mapSize] == 1) {
                    wallCounter++;
                }
                if (i > mapSize && wallArray[i - mapSize] == 1) {
                    wallCounter++;
                }
            }

            if (wallCounter > 2) {
                wallArray[i] = 0;
            } else {
                wallArray[i] = 1;
            }
            wallCounter = 0;
        }
        return wallArray;
    }
 */
    public boolean canIgoHere(int X, int Y) {
        boolean out;

        if (mazeArray[X][Y].getWall()) {
            System.out.println("Cant go there.");
            out = false;
        } else {
            out = true;
        }
        return out;
    }

    public void randomPosition() {
        int numOfMonster = (int) Math.floor((Math.random() * 5) + 3);
        int numOfItems = (int) Math.floor((Math.random() * 3) + 2);
        int numOfMonsterAndItems = (int) Math.floor((Math.random() * 4));
        ArrayList<Integer> randomPositions = randomMonsterAndItemPosition(numOfMonster, numOfItems, numOfMonsterAndItems);

        for (int i = 0; i < mapSize * mapSize; i++) {
            if (i % mapSize == 0 || i % mapSize == mapSize - 1 || i < mapSize || i > mapSize * mapSize - mapSize) {
                mazePositions[i] = 0;
            } else if (randomPositions.contains(i)) {
                if (randomPositions.indexOf(i) < numOfMonster) {
                    mazePositions[i] = 2;
                } else if (randomPositions.indexOf(i) < numOfMonster + numOfItems && randomPositions.indexOf(i) >= numOfMonster) {
                    mazePositions[i] = 3;
                } else if (randomPositions.indexOf(i) < numOfMonster + numOfItems + numOfMonsterAndItems && randomPositions.indexOf(i) >= numOfMonster + numOfItems) {
                    mazePositions[i] = 4;
                } else if (randomPositions.indexOf(i) == randomPositions.size() - 2) {
                    mazePositions[i] = 5;
                } else {
                    mazePositions[i] = 6;
                }
            } else {
                mazePositions[i] = 1;
            }
        }
    }

    private ArrayList<Integer> randomMonsterAndItemPosition(int numOfMonster, int numOfItems, int numOfMonsterAndItems) {
        ArrayList<Integer> randomPositions = new ArrayList<>();
        int numTotalt = numOfMonster + numOfItems + numOfMonsterAndItems + 2; //1 For the dragon boss and toothbrush
        for (int i = 0; i < numTotalt; i++) {
            int randomNum = (int) Math.floor(Math.random() * (mapSize * mapSize));
            if (randomNum % mapSize == 0 || randomNum % mapSize == mapSize - 1 || randomNum < mapSize || randomNum > mapSize * mapSize - mapSize) {
                i--;
            } else {
                if (!randomPositions.contains(randomNum)) {
                    randomPositions.add(randomNum);
                } else {
                    i--;
                }
            }
        }
        return randomPositions;
    }

    public void createMap() {
        int numPos = 0;
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                mazeArray[i][j] = new Room(mazePositions[numPos]);
                numPos++;
            }
        }
    }

    public void updateHeroPosition(int x, int y) {

        this.heroPositionX = x;
        this.heroPositionY = y;
    }

    @Override
    public String toString() {
        String outputString = "[]";

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray.length; j++) {

                if (this.heroPositionX == i && this.heroPositionY == j) {
                    outputString += " " + " H ";
                } else {
                    outputString += " " + mazeArray[i][j];
                }
            }
            outputString += "\n";
        }
        return outputString;
    }
}
