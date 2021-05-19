package com.company;

import java.util.Scanner;

public class Dog {

    private int age;

    public int getAge() {
        return age;
    }
 //   public void setAge(int age){
   //     this.age=age;
   // }
    private int SetNext(int nextInt) {
        return nextInt;
    }

    public int GetParams() {

    Scanner scanner = new Scanner(System.in);
        System.out.println("Input age: ");
        return SetNext(scanner.nextInt());

}




}
