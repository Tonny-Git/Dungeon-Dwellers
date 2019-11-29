package com.company;

public abstract class Position {

    private int posX;
    private int posY;


    public Position(int posX, int poxY){
        this.posX = posX;
        this.posY = poxY;
    }

    public int getPositionX() {
        return posX;
    }

    public int getPositionY() {
        return posY;
    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
}
