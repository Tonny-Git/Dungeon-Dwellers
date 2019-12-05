package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room {

    private Items item;
    private Monster monster;

    private Toothbrush toothbrush = new Toothbrush("Tooth brush", 3);

    private GoldChest goldChest = new GoldChest("Gold Chest", 100);


    private DragonBoss dragon = new DragonBoss();

    private boolean hasWall = false;

   // private ArrayList<Creature> roomCreatures = new ArrayList<>();


    private ArrayList<Items> roomItems = new ArrayList<>();
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
            roomItems.add(goldChest);
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
                placeLootRoom();

                break;
            case 3:
                populateRoom();
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
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

        switch (randomNum) {
            case 0:
                item = new CupOfCoffee("Covfefe", 20);
                roomItems.add(item);
                placeGoldRoom();
                break;



            case 1:
                item = new Gold("Gold Coin", 1);
                roomItems.add(item);
                placeGoldRoom();

        }
    }

    public void placeToothbrushRoom(){

        roomItems.add(toothbrush);
    }


    public void placeGoldRoom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        while (randomNum == 0) {
            item = new Gold("Gold Coin", 1);
            roomItems.add(item);
            randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        }
    }




    public ArrayList<Items> getRoomItems() {
        return roomItems;
    }

    public Monster getMonster() {
        return monster;
    }

    public String getRoomInfo() {
        return getWall() + " "  + getRoomItems();
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

