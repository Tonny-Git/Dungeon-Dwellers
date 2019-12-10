package com.company;

public class Beef extends Items {
    private int heal = 100;

    public Beef(String name, int weight, int heal) {
        super(name, weight);
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public void useItem() {

    }
}
