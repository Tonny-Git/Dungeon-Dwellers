package com.company;

public abstract class Monster extends Creature {
    private int experiencePoints;
    private boolean isdead = false;

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
            System.out.println("You killed " + getName());
            isdead = true;
        }
    }

    public void handleSpecialAttack(Creature attackCreature, int damage) {
        attackCreature.getDamaged(damage);
        System.out.printf("%s did a special attack for %d damage. %s has %d hp left\n", getName(), damage, attackCreature.getName(), attackCreature.getHealth());
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public boolean isIsdead() {
        return isdead;
    }
}
