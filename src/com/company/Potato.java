package com.company;

public class Potato extends Items {
    private int heal = 20;

    public Potato(String name, int weight, int heal) {
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
