package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Room  {

    Creature creature = new Bandit(60, 4);
    Item item = new Item();
    private boolean hasWall = false;

    public Room(boolean wall) {
        this.hasWall = wall;

        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

        wichTypeOfRoom(randomNum);

    }

    public void setHasWall(boolean hasWall) {
        this.hasWall = hasWall;
    }

    public boolean getWall() {
        return this.hasWall;
    }


    private void wichTypeOfRoom(int roomNumber) {

        switch (roomNumber) {
            case 1: // empty
                break;
            case 2: // monster
                break;
            case 3: // item
                break;
            case 4: // boss

        }
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

