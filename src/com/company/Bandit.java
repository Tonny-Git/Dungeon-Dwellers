package com.company;

public class Bandit extends Monster {

    public Bandit() {
        super("Bandit", 60, 8);
        setExperiencePoints(100);
    }

    public void attackEnemy(Creature attackCreature) {
        int typeOfAttack = (int)Math.floor(Math.random() * 100);
        if(typeOfAttack < 10) {
            handleSpecialAttack(attackCreature, getDamage()+4);
        } else {
            handleNormalAttack(attackCreature);
        }
    }
}
