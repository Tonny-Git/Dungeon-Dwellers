package com.company;

public class DragonBoss extends Monster{
    private boolean activeQuest = false;

    public DragonBoss(int health, int damage) {
        super("Elder Dragon", health, damage);
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


    public boolean isActiveQuest() {
        return activeQuest;
    }
}
