package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {


 Random rand = new Random();

 private int n = rand.nextInt(3);

 private ArrayList<String> inhabs = new ArrayList<>();


 private int xPosition = 0;
 private int yPosition = 0;

 public Room(int xPosition, int yPosition){

  this.xPosition = xPosition;
  this.yPosition = yPosition;
  roomInhab();
  









 }

public void roomInhab(){
  if(n == 1){
   inhabs.add("B");}
  else if(n == 2){
   inhabs.add("S");
  }
  else{
   inhabs.add("0");
  }
  };


 public int getMazeRoom() {
  return this.xPosition;

 }

 @Override
 public String toString() {
  String outputString = "";



  for (int i = 0; i < inhabs.size(); i++) {

    outputString += " " + inhabs.get(i);

  }
  return outputString;
 }
}
