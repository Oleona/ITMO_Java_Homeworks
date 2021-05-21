package com.company;

import java.util.Scanner;

public class Cat {

     private   int age;
     protected int newAge;

public int setAge(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input cat age: ");
    age = scanner.nextInt();
    return age;
}


}
