package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1");

        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java");

        System.out.println("Задание 2");

        System.out.println("Посчитайте  (46 + 10) * (10 / 3)");
        int a = (46 + 10) * (10 / 3);
        System.out.println(a);

        System.out.println("Посчитайте  (29) * (4) * (-15)");
        int b = (29) * (4) * (-15);
        System.out.println(b);

        System.out.println("Задание 3");

        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println("result ="+ result);

        System.out.println("Задание 4");
        System.out.println("Даны три числа: 3.6, 4.1, 5.9. В переменной result посчитайте произведение этих чисел.");
        double c=3.6;
        double d=4.1;
        double e=5.9;
        double res = c*d*e;
        System.out.println(res);

        System.out.println("Задание 5");

        Scanner in = new Scanner(System.in);
        System.out.println("Input a number1: ");
        //number1=42
        int num1 = in.nextInt();
        System.out.println("Input a number2: ");
        //number2=100
        int num2 = in.nextInt();
        System.out.println("Input a number3: ");
        //number2=125
        int num3 = in.nextInt();
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

        System.out.println("Задание 6");
        //Для целого числа b выполните следующие условные действия:
        //● Если b нечетное, выведите “Нечетное”
        //● Если b четное, выведите “Четное”
        //● Если b четное и больше 100, выведите “Выход за пределы диапазона”
        System.out.println("Input a number: ");
        int bb = in.nextInt();
        if(bb%2!=0){
            System.out.println("нечетное ");
        }
        else if(bb%2==0 & bb<100){
            System.out.println("четное ");
        }
        else {
            System.out.println("Выход за пределы диапазона");
        }
    }
}