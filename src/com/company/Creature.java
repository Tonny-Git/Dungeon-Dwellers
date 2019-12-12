package com.company;

public abstract class Creature {
    private String name;
    private int health;
    private int damage;

    public Creature(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    //Skriva ut attack
    public void handleNormalAttack(Creature attackCreature) {
        attackCreature.getDamaged(damage);
        System.out.printf("%s did a normal attack for %d damage. %s has %d hp left\n", name, damage, attackCreature.getName(), attackCreature.getHealth());
    }

    public abstract void handleSpecialAttack(Creature attackCreature, int damage);

    public abstract void attackEnemy(Creature attackCreature);

    public abstract void getDamaged(int damageAmount);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void increaseHealth(int health) {
        this.health += health;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }
}
