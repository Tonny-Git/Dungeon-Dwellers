package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room extends Position {


    CupOfCoffee coffe = new CupOfCoffee("Covfefe", 10);
    Toothbrush toothbrush = new Toothbrush("Tooth brush", 1);
    Bandit bandit = new Bandit();
    Spider spider = new Spider();
    DragonBoss dragon = new DragonBoss();

    ArrayList<Creature> roomCreatures = new ArrayList<>();
    ArrayList<Items> roomItems = new ArrayList<>();
    int roomType;

    public void setHasWall(boolean hasWall) {
        this.hasWall = hasWall;
    }


    private boolean hasWall = false;
    private int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

    public Room(int posX, int poxY, int roomType) {
        super(posX, poxY);
        this.roomType = roomType;
        makeRoom(roomType);


    }

    public void makeRoom(int roomType) {
        switch (roomType) {
            case 0:
                hasWall = true;
                break;
            case 1:
                ;
                break;
            case 2:
                populateRoom(randomNum);
                break;
            case 3:
                placeLootRoom(randomNum);
                break;
            case 4:
                placeLootRoom(randomNum);
                populateRoom(randomNum);
                break;


        }
    }


    public boolean getWall() {
        return hasWall;
    }


    public void populateRoom(int roomNumber) {

        switch (roomNumber) {
            case 1:
                roomCreatures.add(bandit);
                break;
            case 2:
                roomCreatures.add(spider);
                break;
            case 3: // item
                break;
            case 4: // boss

        }
    }

    private void placeLootRoom(int roomNumber) {

        switch (roomNumber) {
            case 1:
                roomItems.add(coffe);
                break;
            case 2:
                roomItems.add(toothbrush);
                break;
            case 3: // item
                break;
            case 4: // boss

        }
    }

    public ArrayList<Creature> getRoomCreatures() {
        return roomCreatures;
    }

    public ArrayList<Items> getRoomItems() {
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

