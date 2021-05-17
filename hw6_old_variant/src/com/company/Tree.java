package com.company;

public class Tree {
private int age;
private boolean isLive;
private String name;

    public int getAge(int age) {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean getIsLeave(boolean isLive) {
        return this.isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }
    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
public Tree(int age,String name){
        this.age=age;
        this.name=name;

}
    public Tree(int age,String name, boolean isLive){
        this.age=age;
        this.name=name;
        this.isLive=isLive;

    }
    public Tree(){
        System.out.println("Пустой конструктор без параметров сработал");
    }
    public void GetInfo() {
        System.out.printf("Age: %d\tName: %s\tIs live: %b\n",getAge( age),getName( name),getIsLeave( isLive));
    }

}
