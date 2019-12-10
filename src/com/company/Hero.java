package com.company;

import java.util.ArrayList;

public class Hero extends Creature {

    private int lvl = 1;
    private int totalExp = 0;
    private int positionX = 2;
    private int positionY = 14;
    private Backpack backpack = new Backpack();

    public Hero(String name) {
        super(name, 100, 10);

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

    public void attackEnemy(Creature attackCreature) {
        int typeOfAttack = (int)Math.floor(Math.random() * 100);
        if(typeOfAttack < 10) {
            handleSpecialAttack(attackCreature, getDamage()*2);
        } else {
            handleNormalAttack(attackCreature);
        }
    }

    public void handleSpecialAttack(Creature attackCreature, int damage) {
        attackCreature.getDamaged(damage);
        System.out.printf("%s did a critical attack for %d damage. %s has %d hp left\n", getName(), damage, attackCreature.getName(), attackCreature.getHealth());
    }

    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public boolean hasToothbrush () {
        boolean toothbrush = false;

        if (backpack.findItemInBackpack("toothbrush") == null)
        {
            toothbrush = true;
        }
        return toothbrush;
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
