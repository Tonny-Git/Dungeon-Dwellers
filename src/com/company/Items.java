package com.company;

public abstract class Items {
    private String name;
    private int weight;

    public Items(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public abstract int useItem();
}
