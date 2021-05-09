package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 2, 3, 4, 5};
        int[] nums2 = new int[]{0, 1, 2, 3, 7, 5};
        int[] nums3 = new int[]{0, 0, 1, 1, 5, 5};
        //  checkSorting(nums1);
        //  checkSorting(nums2);
        // checkSorting(nums3);

        // outputArray();

        // swap();

        findUniqueNumber();

    }


//1. Напишите программу, которая проверяет отсортирован ли массив по возрастанию.
// Если он отсортирован по возрастанию то выводится “OK”, если нет,  выводится текст “Please, try again”


    public static void checkSorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int previous = array[i];
            int next = array[i + 1];
            if (previous > next) {
                System.out.println("Please, try again");
                return;
            }
        }
        System.out.println("OK");
    }

//2. Напишите программу, которая считывает с клавиатуры длину массива (например, пользователь вводит цифру 4),
// затем пользователь вводит 4 числа и на новой строке выводится массив из 4 элементов.

    public static void outputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        int len = scanner.nextInt();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print("Input element of array: ");
            num[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(num));

    }

//3. Напишите метод, который меняет местами первый и последний элемент массива.

    public static void swap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        int len = scanner.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(num));
        int first = num[0];
        int last = num[len - 1];
        num[0] = last;
        num[len - 1] = first;
        System.out.println(Arrays.toString(num));
        // поменять местами произвольные элементы
        System.out.print("Input index of the first exchange item: ");
        int index1 = scanner.nextInt();
        System.out.print("Input index of the second exchange item: ");
        int index2 = scanner.nextInt();
        int tmp = num[index1];
        num[index1] = num[index2];
        num[index2] = tmp;
        System.out.println(Arrays.toString(num));
    }
//4. Дан массив чисел. Найдите первое уникальное в этом массиве число.
//Например, для массива [1, 2, 3, 1, 2, 4] это число 3.

    public static void findUniqueNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        int len = scanner.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(num));
        for (int i = 0; i < len; i++) {
            boolean flag=true ;
            for (int j = 0; j < len; j++) {

                if ((num[i]) == (num[j])&& i != j) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                int unic =num[i];
                System.out.print( "First Unique number is " + unic );
                break;
            }

        }

    }

}




