package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room {

    private Items item;

    private Monster monster;


    public int getRoomGold() {
        int goldAmount = roomGold.size();
        return goldAmount;
    }

    private boolean hasWall = false;


    private ArrayList<Items> roomGold = new ArrayList<>();
    private boolean isBossRoom = false;
    private int roomType;
    private boolean isEmpty = false;


    public Room(int roomType) {
        this.roomType = roomType;
        makeRoom(roomType);
    }

    public void setHasWall(boolean hasWall) {
        this.hasWall = hasWall;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public void setBossRoom() {
        monster = new DragonBoss();
        item = new GoldChest("Gold Chest", 100);
        isBossRoom = true;
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
                populateRoom();
                break;
            case 3:
                placeLootRoom();
                break;
            case 4:
                placeLootRoom();
                populateRoom();
                break;

            case 5:
                placeToothbrushRoom();
                break;
            case 6:
                setBossRoom();

        }
    }


    public boolean getWall() {
        return hasWall;
    }


    public void populateRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        switch (randomNum) {
            case 0:
                monster = new Bandit();

                break;
            case 1:
                monster = new Spider();


        }
    }

    public void placeLootRoom() {
       /* int randomNum = ThreadLocalRandom.current().nextInt(0, 1);

        switch (randomNum) {
            case 0: */
        int randomNumItem = ThreadLocalRandom.current().nextInt(0, 4 + 1);

        switch (randomNumItem) {
            case 0:
                item = new CupOfCoffee();
                placeGoldRoom();
                break;
            case 1:
                item = new Potato();
                roomGold.add(item);
                break;
            case 2:
                item = new Carrot();
                roomGold.add(item);
                break;
            case 3:
                item = new Beef();
                roomGold.add(item);
                break;
            case 4:
                Gold goldCoin = new Gold("Gold Coin", 1);
                roomGold.add(goldCoin);
                placeGoldRoom();
                break;
        }
    }


    public void placeToothbrushRoom() {
        item = new Toothbrush("Tooth brush", 3);


    }


    public void placeGoldRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        while (randomNum == 0) {
            Gold goldCoin = new Gold("Gold Coin", 1);
            roomGold.add(goldCoin);
            randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        }
    }


    public Items getRoomItems() {
        return item;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean trueOrFalse) {
        this.isEmpty = trueOrFalse;
    }

    public Monster getMonster() {
        return monster;
    }

    public String getRoomInfo() {
        return getWall() + " " + getRoomItems();
    }

    @Override
    public String toString() {
        String retuner = "[ ]";

        if (hasWall) {
            retuner = " W ";
        }
        return retuner;
    }
}

