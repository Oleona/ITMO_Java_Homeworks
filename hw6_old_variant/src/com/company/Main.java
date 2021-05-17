package com.company;

public class Main {

    public static void main(String[] args) {
        Study study = new Study("Изучение Java - это просто!");
        System.out.println(study.printCourse());
        System.out.println("task2-----------------");
        Car smallCar = new Car();
        Car bigCar = new Car();
        smallCar.setColor("grey");
        smallCar.setName("small");
        smallCar.setWeight(1300);
        smallCar.displayInfo();
        bigCar.setColor("black");
        bigCar.setName("big");
        bigCar.setWeight(5300);
        bigCar.displayInfo();

        System.out.println("---------------------");
        Car smallCar1=new Car("red");
        Car bigCar1 = new Car("green");
        Car smallCar2 = new Car("red", 1500);
        Car bigCar2 = new Car("green",3500);
        smallCar1.displayInfo();
        bigCar1.displayInfo();
        smallCar2.displayInfo();
        bigCar2.displayInfo();
        System.out.println("task3-----------------");
        Home newHome=new Home();
        newHome.setAllValues(20,2020, "newHome");
        Home oldHome=new Home();
        oldHome.setAllValues(3,1950,"oldHome");
        newHome.showAllValues();
        newHome.countAge();
        System.out.println("newhome is "+newHome.countAge()+ " years old");
        oldHome.showAllValues();
        oldHome.countAge();
        System.out.println("oldhome is " + oldHome.countAge()+ " years old");

    }
}
