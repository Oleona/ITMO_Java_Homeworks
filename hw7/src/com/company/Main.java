package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      /*  Car car = new Car();
        car.outPut();
        car.weight = 1000;
        car.color = 'r';
        car.model = "duster";
        car.speed = 120;
        car.outPut();*/
        Truck track = new Truck(2000, "man", 'g', 100, 8, 2500);
        // хотела Car track но тогда метод outPut он видел, а newWheels нет
        track.outPut();
        track.newWheels(10);
        track.outPut();

        Cat cat = new Cat();
        System.out.println("Our new cat is " + cat.setAge() + " year");
        Mecong mecong = new Mecong();
        System.out.println("Our mecong cat is " + mecong.GetMecongAge() + " year");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input age: ");
        mecong.newAge = scanner.nextInt();

        System.out.println(mecong.GetNewAge());
        System.out.println(" в поле главного класса ввели " + mecong.newAge + " в методе вывода переменной главного класса из наследника получили " + mecong.GetNewAge());

        Dog dog = new Dog();
        Schnauzer schnauzer = new Schnauzer();
        dog.GetParams();
        schnauzer.GetParams();

        Plane plane = new Plane();
        Plane.Wing wing = plane.new Wing();
        wing.setWeight(500);
        wing.getWingWeight();

        plane.getPlaneWithWing(700);
        plane.getPlaneWithWing(1400);


    }
}
