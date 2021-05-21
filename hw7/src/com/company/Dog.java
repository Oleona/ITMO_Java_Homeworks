package com.company;

import java.util.Scanner;

public class Dog {

    private int age;
    protected String name;
    Scanner scanner = new Scanner(System.in);

    public void GetParams() {
        System.out.println("Input dog age: ");
        age = scanner.nextInt();
        System.out.println("Our dog is " + age + " year ");

    }

}
