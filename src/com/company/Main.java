package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //DungeonGame dungeonGame = new DungeonGame();

        //Ta bort senare
        int mapSize = 15;

        int[] numArray = new int[225];
        for (int i = 0; i < numArray.length; i++) {
            if (i % mapSize == 0 || i % mapSize == mapSize - 1 || i < mapSize || i > mapSize * mapSize - mapSize) {
                numArray[i] = 1;
            } else {
                numArray[i] = 1;
            }
        }

        numArray = randomizeWalls(numArray, mapSize);

        for (int i = 0; i < numArray.length; i++) {
            if (i % 15 == 0) {
                System.out.println("");
            }
            System.out.print(" " + numArray[i] + " ");
        }
    }

    public static int[] randomizeWalls(int[] numArray, int mapSize) {
        int[] tempArray = numArray;
        int size = mapSize;
        int[][] twoDTempArray = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                twoDTempArray[i][j] = tempArray[i * size + j];
            }
        }

        for (int i = 0; i < 8; i++) {
            int num1 = (int)Math.floor(Math.random()*size);
            int num2 = (int)Math.floor(Math.random()*size);
            int totalNum = num1*15 + num2;
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
                tempArray[i * size + j] = twoDTempArray[i][j];
            }
        }

        return tempArray;
    }
}