package com.company;

public class Mecong extends Cat{

    public int GetMecongAge(){
        return super.getAge();
    }
    public int GetNewAge(int newAge){
        this.newAge=newAge;
        return newAge;
    }
}
