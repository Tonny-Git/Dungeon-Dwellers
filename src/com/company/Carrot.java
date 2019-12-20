package com.company;

public class Carrot extends Items {
    private int heal = 10;

    public Carrot() {
        super("Ugly carrot", 1);
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
        return "Carrot{" +
                "heal=" + heal +
                "weight=" + getWeight() +
                '}';
    }
}
