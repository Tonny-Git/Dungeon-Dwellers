package com.company;

public class Beef extends Items {
    private int heal = 100;

    public Beef() {
        super("Super beef", 15);
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
        return "Beef{" +
                "heal=" + heal +
                "weight=" + getWeight() +
                '}';
    }
}
