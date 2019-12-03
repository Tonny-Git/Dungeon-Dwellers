package com.company;

import java.util.ArrayList;

public class Hero extends Creature {
    //private Backpack backpack = new Backpack(); //Implementera när backpack finns
    private int lvl = 1;
    private int totalExp = 0;


    public Hero(String name) {
        super(name, 100, 10);

    }

    public void putItemIntoBackpack() {
        //Lägg till kod som kallar på en funktion i backpack
    }

    public void gainedExperiencePoints(int experiencePoints) {
        totalExp += experiencePoints;
        while(true) {
            if (totalExp >= ((100 * lvl) + ((lvl-1) * (lvl-1) * 10))) {
                lvl++;
                increaseDamage(10);
                increaseHealth(20);
                System.out.println("You gained a lvl! Your current lvl is: " + lvl);
            } else {
                break;
            }
        }
    }

    //Utveckla vidare vid förlust
    public void getDamaged(int damageAmount) {
        setHealth(getHealth()-damageAmount);
        if(getHealth() <= 0) {
            System.out.println("You died!");
        }
    }

    public int getTotalExp() {
        return totalExp;
    }
}
