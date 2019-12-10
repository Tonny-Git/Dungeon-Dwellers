package com.company;

public class Potato extends Items {
    private int heal = 20;

    public Potato() {
        super("Moldy Potato", 5);
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public void useItem() {

    }
}
