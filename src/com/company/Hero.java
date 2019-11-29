package com.company;

public class Hero extends Position{

    String name = "HoneyBoo";

    public Hero(int posX, int poxY, String name) {
        super(posX, poxY);
        this.name = name;
    }
}
