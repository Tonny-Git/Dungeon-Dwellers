package com.company;

public class Spider extends Monster {

    public Spider() {
        super("Spider", 40, 5);
        setExperiencePoints(50);
    }

    public void attackEnemy(Creature attackCreature) {
        int typeOfAttack = (int)Math.floor(Math.random() * 100);
        if(typeOfAttack < 3) {
            handleSpecialAttack(attackCreature, getDamage()+10);
        } else {
            handleNormalAttack(attackCreature);
        }
    }
}
