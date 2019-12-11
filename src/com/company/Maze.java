package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Maze {

    private int mapSize;
    private Room[][] mazeArray;
    private int[] mazePositions;
    private int heroPositionX = 2;
    private int heroPositionY = 14;


    public Maze(int i) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            int scannerInput;
            try {
                System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
                scannerInput = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("You can only input numbers, please try again!");
                System.out.println("Press enter to continue. . . ");
                scanner.nextLine();
                continue;
            }
            if (scannerInput >= 15 && scannerInput <= 40) {
                mapSize = scannerInput;
                break;
            } else if(scannerInput < 15) {
                System.out.println("Size is out of range. Minimum size is 15 ");
            } else {
                System.out.println("Size is out of range. Maximum size is 40 ");
            }

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
        int numOfMonster = (int) Math.floor((Math.random() * 3) + mapSize);
        int numOfItems = (int) Math.floor((Math.random() * 2) + mapSize/3);
        int numOfMonsterAndItems = (int) Math.floor((Math.random() * 4));
        ArrayList<Integer> randomWallPositions = randomizeWalls();
        ArrayList<Integer> randomPositions = randomMonsterAndItemPosition(numOfMonster, numOfItems, numOfMonsterAndItems, randomWallPositions);

        for (int i = 0; i < mapSize * mapSize; i++) {
            if (i % mapSize == 0 || i % mapSize == mapSize - 1 || i < mapSize || i > mapSize * mapSize - mapSize || randomWallPositions.contains(i)) {
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

    private ArrayList<Integer> randomMonsterAndItemPosition(int numOfMonster, int numOfItems, int numOfMonsterAndItems, ArrayList<Integer> randomWallPositions) {
        ArrayList<Integer> randomPositions = new ArrayList<>();
        int numTotalt = numOfMonster + numOfItems + numOfMonsterAndItems + 2; //1 For the dragon boss and toothbrush
        for (int i = 0; i < numTotalt; i++) {
            int randomNum = (int) Math.floor(Math.random() * (mapSize * mapSize));
            if (randomNum % mapSize == 0 || randomNum % mapSize == mapSize - 1 || randomNum < mapSize || randomNum > mapSize * mapSize - mapSize) {
                i--;
            } else {
                if (!randomPositions.contains(randomNum) && !randomWallPositions.contains(randomNum)) {
                    randomPositions.add(randomNum);
                } else {
                    i--;
                }
            }
        }
        return randomPositions;
    }

    public ArrayList<Integer> randomizeWalls() {
        ArrayList<Integer> tempArray = new ArrayList<>();
        int size = mapSize;
        int[][] twoDTempArray = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                twoDTempArray[i][j] = 1;
            }
        }

        for (int i = 0; i < size/3; i++) {
            int num1 = (int)Math.floor(Math.random()*size);
            int num2 = (int)Math.floor(Math.random()*size);
            int totalNum = num1*size + num2;
            boolean skip = false;

            if (totalNum % size == 0 || totalNum % size == size - 1 || totalNum < size || totalNum > size * size - size) {
                i--;
                continue;
            }

            for (int j = -2; j < 3; j++) {
                for (int k = -2; k < 3; k++) {
                    try {
                        if (twoDTempArray[num1+j][num2+k] == 0) {
                            skip = true;
                            break;
                        }
                    } catch (Exception e) {

                    }
                }
            }

            if(skip) {
                i--;
                continue;
            }

            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    if(j == 0 && k == 0) {

                    } else {
                        twoDTempArray[num1+j][num2+k] = 0;
                    }
                }
            }

            for (int j = 0; j < 1; j++) {
                int randomOpening = (int)Math.floor(Math.random()*4);
                switch (randomOpening) {
                    case 0:
                        if(num1 == 1 || num1 == 2) {
                            j--;
                            continue;
                        }
                        twoDTempArray[num1-1][num2] = 1;
                        break;
                    case 1:
                        if(num2 == 1 || num2 == 2) {
                            j--;
                            continue;
                        }
                        twoDTempArray[num1][num2-1] = 1;
                        break;
                    case 2:
                        if(num2 == size-2 || num2 == size-3) {
                            j--;
                            continue;
                        }
                        twoDTempArray[num1][num2+1] = 1;
                        break;
                    case 3:
                        if(num1 == size-2 || num1 == size-3) {
                            j--;
                            continue;
                        }
                        twoDTempArray[num1+1][num2] = 1;
                        break;
                }
            }
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(twoDTempArray[i][j] == 0) {
                    tempArray.add(i*size + j);
                }
            }
        }

        return tempArray;
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

        heroPositionX = x;
        heroPositionY = y;
    }

    @Override
    public String toString() {
        String outputString = "";

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray.length; j++) {

                if (heroPositionX == i && heroPositionY == j) {
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
