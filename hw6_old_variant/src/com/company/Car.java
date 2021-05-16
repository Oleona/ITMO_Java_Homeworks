package com.company;

public class Car {
    private  String color;
    private  String name;
    private  int weight;

    public String getColor(String color) {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getWeight(int weight) {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Car()
    {

    }

    public Car(String color)
    {
        this.color=color;
    }
    public Car(String color, int weight)
    {
        this.color=color;
        this.weight=weight;
    }


   // public void displayInfo(){
      //  System.out.printf("Color: %s \tName: %s\tWeight: %d\n", color,name,weight);
  //  }
    public void displayInfo(){
        System.out.printf("Color: %s\tName: %s\tWeight: %d\n", getColor(color),getName(name),getWeight(weight));
        //System.out.println("Color: " + getColor(color) + " Name: " + getName(name) + " Weight: "+ getWeight(weight));
    }
}
