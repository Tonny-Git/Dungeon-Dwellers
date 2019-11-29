package com.company;

import java.util.ArrayList;

import java.util.Random;

public class Room {


 Random rand = new Random();

 private int n = rand.nextInt(3);

 private ArrayList<Creature> inhabs = new ArrayList<>();

 private Spider spider = new Spider("Lilla Spindel", 10, 1);
 private Spider nullspider = new Spider("nullSPider", 0, 0);

 private int xPosition = 0;
 private int yPosition = 0;

 private Room(int xPosition, int yPosition){

  this.xPosition = xPosition;
  this.yPosition = yPosition;
  roomInhab();
  









 }

private void roomInhab(){
     if(n == 2){
   inhabs.add(spider);
  }
  else   {inhabs.add(nullspider);}

  }





 @Override
 public String toString() {
  String outputString = "[0]";



 if(inhabs.get(0) == spider){
     return "Spider";
 }

 else if(inhabs.get(0) == nullspider){
         return "NullSpider";
     }

 return outputString;

}}
