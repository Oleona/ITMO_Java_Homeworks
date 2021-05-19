package com.company;

import java.util.Scanner;

public class Cat {

     private  int age;

    private int SetNext(int nextInt) {
        return nextInt;
    }
public int getAge(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input cat age: ");
    age= SetNext(scanner.nextInt());
    return age;
}



}
