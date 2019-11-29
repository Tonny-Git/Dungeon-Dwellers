package com.company;

import java.util.ArrayList;

import java.util.Random;

public class Room {


 Random rand = new Random();

 private int n = rand.nextInt(3);

 private ArrayList<Creature> inhabs = new ArrayList<>();

 private Spider spider = new Spider(10, 1);
private Bandit bandit = new Bandit(20, 2);

 private int xPosition = 0;
 private int yPosition = 0;

 public Room(int xPosition, int yPosition){

  this.xPosition = xPosition;
  this.yPosition = yPosition;
  roomInhab();
  









 }

private void roomInhab(){
     if(n == 2){
   inhabs.add(spider);
  }
  else   {inhabs.add(bandit);}

  }





 @Override
 public String toString() {
  String outputString = "[0]";



 if(inhabs.get(0) == spider){
     outputString = "[S]";
 }

 else if(inhabs.get(0) == bandit){
         outputString = "[B]";
     }

 return outputString;

}}
