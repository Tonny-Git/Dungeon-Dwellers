package com.company;

public abstract class Monster extends Creature {
    private int experiencePoints;

    public Monster(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    //Utveckla vidare
    public void getDamaged(int damageAmount) {
        setHealth(getHealth()-damageAmount);
        if (getHealth() <= 0) {
            //Skriv item drop kåd här.
        }
    }
}
