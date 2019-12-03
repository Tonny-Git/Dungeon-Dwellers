package com.company;

import java.util.ArrayList;

public class Backpack {
    ArrayList<Items> itemsInBackpack = new ArrayList<>();

    public void addItem(Items items){
        itemsInBackpack.add(items);
        System.out.println(itemsInBackpack);
    }

    public int currentBagWeight(){
        int bagWeight = 0;
        for (Items items : itemsInBackpack){
            bagWeight += items.getWeight();
        }
        return bagWeight;
    }
}
