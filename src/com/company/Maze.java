package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Maze{

    private int mapSize = 10;
    private Room[][] mazeArray;
    private int[] mazePositions = new int[mapSize*mapSize];

    /*
    public Maze() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
        int scannerInput = scanner.nextInt();

        if (scannerInput > 0 && scannerInput < 40) {
            this.mapSize = scannerInput;
        }

        mazeArray = new Room[mapSize][mapSize];

        System.out.println(mazeArray.toString());

        for (int col = 0; col < mazeArray.length; col++) {
            for (int row = 0; row < mazeArray.length; row++) {
                if (mazeArray[col][row] == (mazeArray[col][0]) || (mazeArray[col][row] == (mazeArray[0][row]))) {
                    mazeArray[col][row] = new Room(col, row, true); // ska vara vägg
                } else {
                    mazeArray[col][row] = new Room(col, row, makeWall(col, row));
                }
                mazeArray[1][14] = new Room(col, row, false); // ska vara tomm
            }
        }
        System.out.println(mazeArray.toString());
    }


     */
    public Room getMazeRoom(int xPosition, int yPosition) {

        return mazeArray[xPosition][yPosition];

    }
    public Room[][] getMazeArray(){
        return this.mazeArray;
    }


    private boolean makeWall(int col, int row) {

        int wallCounter = 0;
        boolean returner = false;


        for (int i = -1; i <= 1; i++) {
            if (mazeArray[col + i][row].getWall()) {
                wallCounter++;
                if (mazeArray[col][row + i].getWall()) {
                    wallCounter++;
                }
            }
        }
        returner = wallCounter > 2;
        return returner;
    }

    public boolean canIgoHere(int X, int Y) {
        boolean out = false;

        if (mazeArray[X][Y].getWall()) {
            System.out.println("Cant go there.");
            out = false;
        } else {
            out = true;
        }
        return out;
    }

    public void randomPosition () {
        int numOfMonster = (int)Math.floor((Math.random()*5)+3);
        int numOfItems = (int)Math.floor((Math.random()*3)+2);
        int numOfMonsterAndItems = (int)Math.floor((Math.random()*4));
        ArrayList<Integer> randomPositions = randomMonsterAndItemPosition(numOfMonster, numOfItems, numOfMonsterAndItems);

        for(int i = 0; i < mapSize*mapSize; i++) {
            if(i % mapSize == 0 || i % mapSize == mapSize-1 || i < mapSize || i > mapSize*mapSize - mapSize) {
                mazePositions[i] = 0;
            } else if(randomPositions.contains(i)) {
                if(randomPositions.indexOf(i) < numOfMonster) {
                    mazePositions[i] = 2;
                } else if(randomPositions.indexOf(i) < numOfMonster+numOfItems && randomPositions.indexOf(i) >= numOfMonster) {
                    mazePositions[i] = 3;
                } else if (randomPositions.indexOf(i) < numOfMonster+numOfItems+numOfMonsterAndItems && randomPositions.indexOf(i) >= numOfMonster+numOfItems) {
                    mazePositions[i] = 4;
                } else {
                    mazePositions[i] = 5;
                }
            } else {
                mazePositions[i] = 1;
            }
        }
    }

    private ArrayList<Integer> randomMonsterAndItemPosition (int numOfMonster, int numOfItems, int numOfMonsterAndItems) {
        ArrayList<Integer> randomPositions = new ArrayList<>();
        int numTotalt = numOfMonster + numOfItems + numOfMonsterAndItems + 1; //1 For the dragon boss
        for(int i = 0; i < numTotalt; i++) {
            int randomNum = (int)Math.floor(Math.random()*(mapSize*mapSize));
            if(randomNum % mapSize == 0 || randomNum % mapSize == mapSize-1 || randomNum < mapSize || randomNum > mapSize*mapSize - mapSize) {
                i--;
            } else {
                if(!randomPositions.contains(randomNum)) {
                    randomPositions.add(randomNum);
                } else {
                    i--;
                }
            }
        }
        return randomPositions;
    }

    @Override
    public String toString() {
        String outputString = "";

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                outputString += " " + mazeArray[i][j];
            }
        }
        return outputString;
    }
}
