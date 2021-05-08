package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        printOddNumbers();
       printDivisibility();
        printDivisibility1();
        System.out.println("Result: " + calculateSum());
        System.out.println("Result: " + calculateFromThreeNumbers());
        System.out.println("Result: " + checkingFirstLastArrayElement());
        System.out.println("Result: " + checkNumberAvailability());
        System.out.println("Result: " + checkNumberAvailability1());
    }

    //1. выводит на консоль нечетные числа от 1 до 99. Каждое число печатать с новой строки.
    public static void printOddNumbers() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    //2. выводит числа от 1 до 100, которые делятся на 3, 5 и на то и другое (то есть и на 3 и на 5)

    public static void printDivisibility() {
        for (int i = 0; i <= 100; i++) {
            int num1 = 3;
            int num2 = 5;
            int num3 = num1 * num2;
            if (i % num1 == 0) {
                System.out.println(i + " Делится на " + num1);
                if (i % num3 == 0) {
                    System.out.println(i + " Делится на " + num1 + " и " + num2);
                }
            } else if (i % num2 == 0) {
                System.out.println(i + " Делится на " + num2);

            }
        }

    }

    // 2. Второй вариант решения
    public static void printDivisibility1() {

        StringBuilder strBuilder = new StringBuilder();
        StringBuilder strBuilder1 = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            int num1 = 3;
            int num2 = 5;
            int num3 = num1 * num2;
            if (i % num1 == 0) {
                strBuilder.append(i );
                strBuilder.append(" " );
                if (i % num3 == 0) {
                    strBuilder1.append(i );
                    strBuilder1.append(" " );
                }
            } else if (i % num2 == 0) {
                strBuilder2.append(i );
                strBuilder2.append(" ");
            }
        }
        System.out.println("Делится на 3:  " + strBuilder.toString());
        System.out.println("Делится на 5:  " + strBuilder2.toString());
        System.out.println("Делится на 3 и на 5:  " + strBuilder1.toString());

    }


    //3.вычислить сумму двух целых чисел и вернуть true, если сумма равна третьему целому числу.

    public static boolean calculateSum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int num1 = in.nextInt();
        System.out.println("Input a second number: ");
        int num2 = in.nextInt();
        System.out.println("Input a third number: ");
        int num3 = in.nextInt();
        // System.out.println("Result: " + result);
        return num1 + num2 == num3;
    }

    //4.принимает от пользователя 3 целых числа и возвращает true, если второе больше первого, а третье больше второго.
    public static boolean calculateFromThreeNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int num1 = in.nextInt();
        System.out.println("Input a second number: ");
        int num2 = in.nextInt();
        System.out.println("Input a third number: ");
        int num3 = in.nextInt();

        return (num3 > num2) && (num2 > num1);
    }
//5. является ли 3  первым или последним элементом массива целых чисел. Длина массива больше или равна двум.

    public static boolean checkingFirstLastArrayElement() {
        int len = 0;
        Scanner in = new Scanner(System.in);
        while (len < 2) {
            System.out.print("How long is your array: ");
            len = in.nextInt();
        }
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(num));
        return (num[0] == num[len - 1]) && (num[0] == 3);

    }

//6. проверить, что массив содержит число 1 или 3.

    public static boolean checkNumberAvailability() {

        Scanner in = new Scanner(System.in);
        System.out.print("How long is your array: ");
        int len = in.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(11);
        }
        System.out.println(Arrays.toString(num));
        boolean result = false;
        for (int i = 0; i < len; i++) {
            if (num[i] == 1 || num[i] == 3) {
                result = true;
                break;
            }
        }
        return result;
    }

    // 6. Второй вариант решения
    public static boolean checkNumberAvailability1() {

        Scanner in = new Scanner(System.in);
        System.out.print("How long is your array: ");
        int len = in.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(11);
        }
        System.out.println(Arrays.toString(num));
        boolean result ;
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        int key = Arrays.binarySearch(num, 1);
        System.out.println(key);
        int key1 = Arrays.binarySearch(num, 3);
        System.out.println(key1);
        result = ((key >= 0) || (key1 >= 0));
        return result;
    }


}
