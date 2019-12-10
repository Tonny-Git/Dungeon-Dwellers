package com.company;

public class CupOfCoffee extends Items {
    private int heal = 50;

    public CupOfCoffee(String name, int weight) {
        super(name, weight);
    }

    public int getHeal() {
        return heal;
    }
}
