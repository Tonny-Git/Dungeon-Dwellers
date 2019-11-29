package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Room extends Position {

    Creature creature = new Creature();
    Item item = new Item();

    public Room(int posX, int poxY) {
        super(posX, poxY);

        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

        wichTypeOfRoom(randomNum);

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

        return "[]";
    }
}

