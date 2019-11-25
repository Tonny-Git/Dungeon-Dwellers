package com.company;

public class Position {

    private int posX;
    private int posY;


    public Position(int posX, int poxY){
        this.posX = posX;
        this.posY = poxY;
    }

    public int getPosition() {
        return posX + posY;
    }

    public void setPosX(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
