package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Maze maze = new Maze();
        maze.randomPosition();
        Room room = new Room(1,2, 0);
        Room room2 = new Room(1,2, 1);
        Room room3 = new Room(1,2, 2);
        Room room4 = new Room(1,2, 3);
        Room room5 = new Room(1,2, 4);


        System.out.println(room.getRoomInfo());
        System.out.println(room2.getRoomInfo());
        System.out.println(room3.getRoomInfo());
        System.out.println(room4.getRoomInfo());
        System.out.println(room5.getRoomInfo());


        /*
        for(int i = 0; i < maze.mazePositions.length; i++) {
            System.out.print(maze.mazePositions[i]);
            if(i % maze.mapSize == maze.mapSize-1) {
                System.out.println("");
            }
        }
        */
        //Maze maze = new Maze();
        //DungeonGame game = new DungeonGame();

        //System.out.println(maze.toString());

        // 0 wall, 1 empty room, 2 monster, 3 item, 4 item/monster, 5 boss
    }
}
