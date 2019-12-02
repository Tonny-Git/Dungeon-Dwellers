package com.company;

public class DragonBoss extends Monster{
    private boolean activeQuest = false;

    public DragonBoss() {
        super("Elder Dragon", 300, 20);
        setExperiencePoints(1000);
    }

    //Quest
    public void giveOutQuest() {
        activeQuest = true;
    }

    //QuestReward
    public void giveOutReward() {

    }

    //Special Attack
    public void attackEnemy(Creature attackCreature) {
        int typeOfAttack = (int)Math.floor(Math.random() * 100);
        if(typeOfAttack < 10) {
            handleSpecialAttack(attackCreature, getDamage()+10);
        } else {
            handleNormalAttack(attackCreature);
        }
    }

    public boolean isActiveQuest() {
        return activeQuest;
    }
}
