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
    public int useItem() {


        return getHeal();
    }

    @Override
    public String toString() {
        return "CupOfCoffee{" +
                "heal=" + heal +
                "weight=" + getWeight() +
                '}';
    }
}
