package com.company;

public class Truck extends Car{

    private int numberWheels;
    private int weightLimit;
    public int getWeightLimit(){
        return weightLimit;
    }
    public int getNumberWheels(){
        return numberWheels;
    }

    public void newWheels(int numberWheels){
        this.numberWheels=numberWheels;
        System.out.printf("Number wheels of this truck is %d \n", numberWheels);
    }

   @Override public void outPut (){
        super.outPut();
       System.out.println("количество колес " + numberWheels);
       System.out.println("предельный вес "+ weightLimit);
   }

    public Truck(int w, String m, char c, float s,int numberWheels,int weightLimit){

        super(w, m, c, s);
        this.numberWheels=numberWheels;
        this.weightLimit=weightLimit;

    }

}
