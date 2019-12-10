package com.company;

public class Toothbrush extends Items {
    public Toothbrush(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void useItem() {
        System.out.println("You cant use this item!");
    }
}
