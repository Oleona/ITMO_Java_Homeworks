package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.outPut();
        car.weight = 1000;
        car.color = 'r';
        car.model = "duster";
        car.speed = 120;
        car.outPut();
        Truck track = new Truck(2000, "man", 'g', 100, 8, 2500);
        // хотела Car track но тогда метод outPut он видел, а newWheels нет
        track.outPut();
        track.newWheels(10);
        track.outPut();
        Cat cat = new Cat();
        System.out.println("Our new cat is "+cat.getAge()+" year");
		Mecong mecong=new Mecong();
		System.out.println("Our mecong cat is "+mecong.GetMecongAge()+" year");

		Dog dog=new Dog();
        System.out.println("Our dog is "+ dog.GetParams()+ " year");

    }
}
