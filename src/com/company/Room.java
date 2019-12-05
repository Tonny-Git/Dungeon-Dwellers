package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room extends Position {

    private Monster monster;
    private CupOfCoffee coffe = new CupOfCoffee("Covfefe", 20);
    private Toothbrush toothbrush = new Toothbrush("Tooth brush", 3);
    private Gold gold = new Gold("Gold Coin", 1);
    private GoldChest goldChest = new GoldChest("Gold Chest", 100);
    private Bandit bandit = new Bandit();
    private Spider spider = new Spider();
    private DragonBoss dragon = new DragonBoss();

    private boolean hasWall = false;

    private ArrayList<Creature> roomCreatures = new ArrayList<>();


    private ArrayList<Items> roomItems = new ArrayList<>();
    private boolean isBossRoom = false;
    private int roomType;
    private boolean isEmpty = false;


    public Room(int posX, int poxY, int roomType) {

        super(posX, poxY);
        this.roomType = roomType;

        makeRoom(roomType);


    }

    public void setHasWall(boolean hasWall) {
        this.hasWall = hasWall;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public void setBossRoom(boolean bossRoom) {
        isBossRoom = bossRoom;
        if (isBossRoom) {
            roomCreatures.clear();
            roomCreatures.add(dragon);
            roomItems.clear();
            roomItems.add(goldChest);
        }
    }

    public void makeRoom(int roomType) {
        switch (roomType) {
            case 0:
                hasWall = true;
                break;
            case 1:
                isEmpty = true;

                break;
            case 2:
                placeLootRoom();

                break;
            case 3:
                populateRoom();
                break;
            case 4:
                placeLootRoom();
                populateRoom();
                break;


        }
    }


    public boolean getWall() {
        return hasWall;
    }


    public void populateRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        switch (randomNum) {
            case 0:
                roomCreatures.add(bandit);
                break;
            case 1:
                roomCreatures.add(spider);


        }
    }

    public void placeLootRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

        switch (randomNum) {
            case 0:
                roomItems.add(coffe);
                placeGoldRoom();
                break;
            case 1:
                roomItems.add(toothbrush);
                placeGoldRoom();
                break;

            case 2:
                roomItems.add(gold);
                placeGoldRoom();

        }
    }


    public void placeGoldRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        while (randomNum == 0) {
            roomItems.add(gold);
            randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        }
    }


    public ArrayList<Creature> getRoomCreatures() {
        return roomCreatures;
    }

    public ArrayList<Items> getRoomItems() {
        return roomItems;
    }

    public String getRoomInfo() {
        return getWall() + " " + getRoomCreatures() + " " + getRoomItems();
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

