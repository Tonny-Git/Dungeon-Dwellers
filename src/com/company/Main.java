package com.company;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero("Tonny");
        System.out.println(hero.getHealth());
        hero.gainedExperiencePoints(210);
        System.out.println(hero.getHealth());
    }
}
