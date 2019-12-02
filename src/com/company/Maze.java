package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Maze {

    private String wall = "W";
    private String door = "D";
    private String hero = "H";
    private int mapSize = 15;
    private Room[][] mazeArray;


    public Maze() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big map do you want?" + "\n" + "(Standard is 15 by 15)");
        int scannerInput = scanner.nextInt();

        if(scannerInput > 0 &&  scannerInput < 40) {
            this.mapSize = scannerInput;
        }

        mazeArray = new Room[mapSize][mapSize];

        for (int col = 0; col < mazeArray.length; col++) {
            for (int row = 0; row < mazeArray.length; row++) {
                if (mazeArray[col][row] == (mazeArray[col][0]) || (mazeArray[col][row] == (mazeArray[0][row]))) {
                    mazeArray[col][row] = new Room(col,row); // ska vara tomt
                } else {
                    mazeArray[col][row] = new Room(col,row);
                }
                mazeArray[1][14] = new Room(col,row); // ska vara tomt
            }
        }
    }

    public Room getMazeRoom(int xPosition, int yPosition) {

        return mazeArray[xPosition][yPosition];

    }
    private void calulateIfWallOrNot() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

        if (  )

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
