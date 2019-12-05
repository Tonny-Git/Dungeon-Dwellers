package com.company;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Items> itemsInBackpack = new ArrayList<>();

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

    public ArrayList<Items> getItemsInBackpack() {
        return itemsInBackpack;
    }

    public void showContent(){
        System.out.println(itemsInBackpack);
    }

    public Items findItemInBackpack(String itemToSearchFor){
        for (Items items : itemsInBackpack){
            if (items == null){
                continue;
            }
            if (itemToSearchFor.equals(items.getName())){
                return items;
            }
        }
        return null;
    }
}
