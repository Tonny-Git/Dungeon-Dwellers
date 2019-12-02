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

    //Skriva attack
    public void handleNormalAttack(Creature attackCreature) {
        attackCreature.getDamaged(damage);
    }

    public abstract void attackEnemy();

    public abstract void getDamaged(int damageAmount);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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
}
