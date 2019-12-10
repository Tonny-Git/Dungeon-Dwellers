package com.company;

public class Carrot extends Items {
    private int heal = 10;

    public Carrot(String name, int weight, int heal) {
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
