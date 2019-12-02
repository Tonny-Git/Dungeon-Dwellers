package com.company;

public class Bandit extends Monster {

    public Bandit(int health, int damage) {
        super("Bandit", health, damage);
        setExperiencePoints(100);
    }

    public void attackEnemy(Creature attackCreature) {

    }
}
