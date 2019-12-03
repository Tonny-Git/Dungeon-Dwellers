package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


    private int mapSize = 15;
    private Room[][] mazeArray;



    public Maze() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
        int scannerInput = scanner.nextInt();

        if (scannerInput > 0 && scannerInput < 40) {
            this.mapSize = scannerInput;
        }

        mazeArray = new Room[mapSize][mapSize];

        System.out.println(mazeArray);

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
        System.out.println(mazeArray);
    }

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
