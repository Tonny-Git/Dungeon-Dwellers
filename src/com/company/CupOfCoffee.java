package com.company;

public class CupOfCoffee extends Items {
    private int heal = 50;

    public CupOfCoffee() {
        super("Yesterdays coffee", 3);
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public void useItem() {

    }
}
