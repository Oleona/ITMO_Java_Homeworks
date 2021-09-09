package com.company;

import java.util.stream.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Все методы должны иметь проверку параметров и генерировать исключения при\n" +
                "необходимости.");
        // MaxElement();
        // IsTheArraySquare();
        // SumStringsMatrix();
        //ArrayRandomSymbolsAlphabet();
        RandomSearchMatchesInArrays();

    }

    public static void MaxElement() {
        System.out.println("Написать метод для поиска наибольшего элемента в двумерном массиве.");
        try {
            int[][] data = new int[2][7];
            Random random = new Random();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++)
                    data[i][j] = random.nextInt(101);
            }
            System.out.println(Arrays.deepToString(data));

            int max = data[0][0];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (max < data[i][j]) {
                        max = data[i][j];
                    }
                }
            }
            System.out.println("Largest Element :" + max);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Что-то  пошло не так");
        }
    }

    public static void IsTheArraySquare() {
        System.out.println("Написать метод, который проверяет, является ли двумерный массив квадратным.");
        try {
            int[][] data = new int[4][4];
            int[][] data1 = new int[3][6];
            Random random = new Random();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++)
                    data[i][j] = random.nextInt(101);
            }
            System.out.println(Arrays.deepToString(data));

            boolean flag = true;
            for (int j = 0; j < data.length; j++) {

                if (data.length != data[j].length) {
                    System.out.println("Not a Square!");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("It is a Square");
            }
            for (int i = 0; i < data1.length; i++) {
                for (int j = 0; j < data1[i].length; j++)
                    data1[i][j] = random.nextInt(101);
            }
            System.out.println(Arrays.deepToString(data1));
            for (int j = 0; j < data1.length; j++) {

                if (data1.length != data[j].length) {
                    System.out.println("Not a Square!");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("It is a Square");
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Вышли за границу массива");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Что-то  пошло не так");
        }
    }

    public static void SumStringsMatrix() {

        System.out.println("Написать метод, который, в двумерном массиве (матрице) ищет строку, сумма\n" +
                "элементов которой является максимальной среди всех строк матрицы.");
        try {
            int sum = 0;
            int lmax = -1;
            int max = Integer.MIN_VALUE;
            int[][] data = new int[4][4];
            Random random = new Random();
            for (int i = 0; i < data.length; i++) {
                sum = 0;
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = random.nextInt(101);
                    sum += data[i][j];
                }

                if (max < sum) {
                    max = sum;
                    lmax = i;
                }
            }
            System.out.println(Arrays.deepToString(data));
            System.out.println("Max in line " + (lmax + 1));
            System.out.print("sum = " + max);

        } catch (IllegalArgumentException ex) {
            System.out.println("bound must be positive");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Выход за пределы массива");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Что-то  пошло не так");
        }


    }

    public static void ArrayRandomSymbolsAlphabet() {
        System.out.println("Двумерный массив MxN заполнить случайными символами алфавита");
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a rows number: ");
            int rows = in.nextInt();
            System.out.print("Input a columns number: ");
            int columns = in.nextInt();

            char[][] table = new char[rows][columns];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    table[r][c] = (char) ((int) (Math.random() * 26) + 65);
                    System.out.print(table[r][c] + " ");
                }
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, please enter a number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }


    }

    public static void RandomSearchMatchesInArrays() {
        System.out.println("Дан массив чисел numbers, и дан массив weight такой же длины.\n " +
                "Задача: написать метод, который бы случайно выбирал число из первого массива, которое есть во втором массиве.");
        System.out.println("Моя логтка- раз мы выбираем случайным образомч исло из первого массива, " +
                "то можем много раз выбирать одно и то же число" +
                "Но нужно перебрать или до найденного или все, и написать, что не нашлось ");
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a  size of the arrays: ");
            int size = in.nextInt();
            int[] numbers = new int[size];
            int[] weight = new int[size];
            Object[] weightcopy = new Object[size];
            SortedSet<Integer> numberSet = new TreeSet<>();
            Random random = new Random();

            for (int j = 0; j < size; j++) {
                numbers[j] = random.nextInt(101);
            }
            for (int i = 0; i < size; i++) {
                weight[i] = random.nextInt(101);
            }
            Arrays.sort(weight);
            int sum = IntStream.of(weight).sum();
            int sum1 = 0;
            System.out.println("numbers:  " + Arrays.toString(numbers));
            System.out.println("weight:  " + Arrays.toString(weight));
            boolean flag = true;
            while (flag) {
                int num = random.nextInt(size);
                int search = weight[num];
                System.out.println("number for search " + search);
                for (int index = 0; index < size; index++) {
                    if (numbers[index] == search) {
                        System.out.println(search + " found at index: " + index);
                        flag = false;

                    } else {
                        numberSet.add(search);
                        weightcopy = numberSet.toArray();
                        int[] ints = Arrays.stream(weightcopy).mapToInt(o -> (int) o).toArray();
                        sum1 = IntStream.of(ints).sum();
                        if (sum == sum1) {
                            System.out.println(" no matches");
                            flag = false;
                            break;
                        }
                    }
                }
            }
            //
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, please enter a number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
}

