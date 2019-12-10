package com.company;

public class Toothbrush extends Items {
    private int numOfToothbrush;

    public Toothbrush(String name, int weight) {
        super(name, weight);
    }

    public void usedToothbrush{
        if (numOfToothbrush == 0){
            System.out.println("You cant do quest");
        } else {
            System.out.println("You can do the quest");
        }
    }
}
