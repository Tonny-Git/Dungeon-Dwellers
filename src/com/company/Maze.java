package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Maze{

    private int mapSize = 15;
    private Room[][] mazeArray;
    

    public Maze() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
        int scannerInput = scanner.nextInt();

        if (scannerInput > 0 && scannerInput < 40) {
            this.mapSize = scannerInput;
        }

        Room[][] mazeArray = new Room[mapSize][mapSize];

        System.out.println(mazeArray.toString());

        for (int col = 0; col < mazeArray.length; col++) {
            for (int row = 0; row < mazeArray.length; row++) {
                mazeArray[col][row] = new Room(false); // skapa alla rum
            }
        }

        for (int col = 0; col < mazeArray.length; col++) {
            for (int row = 0; row < mazeArray.length; row++) {
                if (mazeArray[col][row] == (mazeArray[col][0]) || (mazeArray[col][row] == (mazeArray[0][row]))) {
                    mazeArray[col][row] = new Room(true); // skapar ramen
                } else {
                    mazeArray[col][row] = new Room(makeWall(col, row)); // sätt dit väggar
                }
            }
        }
        mazeArray[(mazeArray.length + 1) - mazeArray.length]
                [mazeArray.length - 1] = new Room(true); // ska vara tomm
    }

    public Room getMazeRoom(int xPosition, int yPosition) {

        return mazeArray[xPosition][yPosition];

    }

    public Room[][] getMazeArray() {
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
        if (wallCounter > 2) {
            returner = true;
        } else {
            returner = false;
        }
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
