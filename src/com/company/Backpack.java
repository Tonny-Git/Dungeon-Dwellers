package com.company;

import java.util.ArrayList;

public class Backpack {
    ArrayList<Items> itemsInBackpack = new ArrayList<>();

    public addItem(Items items){
        itemsInBackpack.add(items);
        System.out.println(itemsInBackpack);
    }
}
