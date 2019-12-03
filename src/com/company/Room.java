package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room extends Position {

    Creature bandit = new Bandit(60, 4);
    Creature spider = new Spider(20,5);
    Creature dragon = new DragonBoss(500,50);

    ArrayList<Creature> roomCreatures = new ArrayList<>();
    ArrayList<Creature> roomItems = new ArrayList<>();
    String roomType;

    public void setHasWall(boolean hasWall) {
        this.hasWall = hasWall;
    }


    Item item = new Item();
    private boolean hasWall = false;
    private int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

    public Room(int posX, int poxY, String roomType) {
        super(posX, poxY);
        makeRoom(roomType);




    }

    public void makeRoom(String roomType){
        switch (roomType) {
            case "wall": hasWall=true;
                break;
            case "empty": ;
                break;
            case "monster": populateRoom(randomNum);
                break;
            case "item": placeLootRoom(randomNum);
                break;
            case "item/monster": placeLootRoom(randomNum);
                break;
            case "boss": placeLootRoom(666);

        }
    }



    public boolean getWall() {
        return hasWall;
    }


    public void populateRoom(int roomNumber) {

        switch (roomNumber) {
            case 1: roomCreatures.add(bandit);
                break;
            case 2: roomCreatures.add(spider);
                break;
            case 3: // item
                break;
            case 4: // boss

        }
    }

    private void placeLootRoom(int roomNumber) {

        switch (roomNumber) {
            case 1: roomCreatures.add(bandit);
                break;
            case 2: roomCreatures.add(spider);
                break;
            case 3: // item
                break;
            case 4: // boss

        }
    }

    public ArrayList<Creature> getRoomCreatures() {
        return roomCreatures;
    }

    public ArrayList<Creature> getRoomItems() {
        return roomItems;
    }

    @Override
    public String toString() {
        String retuner = " ";

        if (this.hasWall) {
            retuner = "W";
        }
        return retuner;
    }
}

