package com.company;

import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 2, 3, 4, 5};
        int[] nums2 = new int[]{0, 1, 2, 3, 7, 5};
        int[] nums3 = new int[]{0, 0, 1, 1, 5, 5};
        System.out.println("Task1");
         checkSorting(nums1);
          checkSorting(nums2);
         checkSorting(nums3);

        System.out.println("Task2");

         outputArray();

        System.out.println("Task3");

         swap();

        System.out.println("Task4");

         findUniqueNumber();
        System.out.println();
        System.out.println("Task5");
         calculatingFibonacci();

        System.out.println("Task6");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        int len = scanner.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(num));
        mergeSort(num,0,len-1);
         System.out.println(Arrays.toString(num));
        System.out.print("Input number of frequently occurring elements: ");
        int k = scanner.nextInt();

        System.out.println("Task7");
        System.out.println("Используем массив из задачи 8");
        findСommonШtems(num, k);

        System.out.println("Task from lesson");

        removeNumber();


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
            boolean flag = true;
            for (int j = 0; j < len; j++) {

                if ((num[i]) == (num[j]) && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int unic = num[i];
                System.out.print("First Unique number is " + unic);
                break;
            }
        }
    }

//5. Вычислить N-е число Фибоначчи. Не использовать рекурсию и массивы, только циклы.
    // ряд начинаем с числа 1

    public static void calculatingFibonacci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input amount of numbers: ");
        int quantity = scanner.nextInt();
        if (quantity <= 2) {
            System.out.println(quantity + "число Фибоначчи равно 1");
        } else {
            int[] arr = new int[quantity];
            arr[0] = 1;
            arr[1] = 1;
            int sum = 0;
            for (int i = 2; i < quantity; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
                sum = arr[quantity - 1];
            }
            System.out.println(quantity + " число Фибоначчи равно " + sum);


        }
    }

    // 6. Заполните массив случайным числами и отсортируйте его. Используйте сортировку слиянием.
    //разделяем на подмассивы до среднего элемента
    //Если бы не посмотрела разбор в интернет, я бы не написала
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        //вызываем слияние
        merge(array, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        // вычисляем размер каждой половинки и создание временные массивы
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];

        // копируем отсортированные исходные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];

       //копируем временные массивы в основной, учитывая где остался минимальный нескопированный кусок
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    //7. ***Дан массив и число K. Найдите первые K самых часто встречающихся элементов.
    // ПАДАЕИ при размере массива около 90 элементов и выводе большого числа наибольших чисел. Для небольших массивов работает корректно.
    //Исправить не получилось.
    public static void findСommonШtems(int[] array, int k) {
        String result = null;
        String myResult=null;
        // создаем массив частот вхождений элементов.
        int[] frequencyArray = new int[array.length];
        for (int i = 0; i < array.length; i++)

            for (int j = 0; j < array.length; j++)
                if (array[i] == array[j]) {

                    frequencyArray[i]++;
                }
        System.out.println("Our frequency array is: ");
        System.out.println(Arrays.toString(frequencyArray));

        // создадим карту, где ключем будет число вхождений, а значениями элементы массива с этим количеством вхождений
        Map<Integer, ArrayList<Integer>> mapFrequency = new HashMap<>();
        ArrayList<Integer> values = new ArrayList<Integer>();

        //найдем максимум в массиве частот, так как карта нам нужна размером не больше, чем это значение
        int max = frequencyArray[0];
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > max) {
                max = frequencyArray[i];
            }
        }
        for (int i = 1; i <= max; i++) {
            mapFrequency.put(i, values);
        }

        //  mapFrequency.forEach((Integer, integer) -> System.out.println(Integer + ", " + integer));


        int j = 1;
        while (j <= max) {
            for (int i = 0; i < frequencyArray.length; i++) {
                if (frequencyArray[i] == j) {
                    //добавляем в мап эл-т исходного массива, соответствующий частоте вхождения j для эл. из частотного массива
// проверяем, чтобы не было дубликатов
                    if (!values.contains(array[i])) {
                        values.add(array[i]);
                    }
                }
            }
            mapFrequency.put(j, values);
            j++;

            values = new ArrayList<Integer>();
        }
        System.out.println("---------------------");
        System.out.println("Our map is: ");
        mapFrequency.forEach((Integer, integer) -> System.out.println(Integer + ", " + integer));
// Дальше нужно вытащить эти значения из карты, моих знаний сделать это красиво не хватило, поэтому куча телодвижений.
        //Наверное, стоило просто преобразовать многомерный массив в одномерный, но сил не хватило.

        Collection<ArrayList<Integer>> values1 = mapFrequency.values();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>(values1);
        for (Entry m : mapFrequency.entrySet()) {
            stringBuilder.append(m.getValue());
          //  System.out.println(stringBuilder.toString());

            result = stringBuilder.toString();
          //  System.out.println(result.replace("][", ", "));

            String result1 = result.replace("][", ", ");
            result1 = result1.replaceAll("\\p{P}", "");
           // System.out.println(result1);
            String result2 = result1.trim().replaceAll(" +", " ");

          //  System.out.println(result2);
            int[] numArr = Arrays.stream(result2.split(" ")).mapToInt(Integer::parseInt).toArray();
            //  System.out.println(Arrays.toString(numArr));
   // создаем лист, куда записываем к самых частых чисел, если к меньше, чем весь массив,
     // или весь массив, если чисел запрошено больше, чем в массиве
            int it;
            ArrayList<Integer> myRes = new ArrayList<Integer>();
            if (k < numArr.length) {
                it = numArr.length - (k);
                for (int i = it; i < +numArr.length; i++) {
                    myRes.add(numArr[i]);
                }
            } else {
                for (int i = 0; i < numArr.length; i++) {
                    myRes.add(numArr[i]);
                }
            }
  //Переворачиваем массив, чтобы первым выводилось наиболее частое число
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int i = myRes.size() - 1; i >= 0; i--) {
                stringBuilder1.append(myRes.get(i));
                stringBuilder1.append(" ");
            }
             myResult= stringBuilder1.toString();
            //System.out.println(k + " more often element is: " + (stringBuilder1.toString()));
        }

        System.out.println(k + " more often element is: " + myResult);
    }


    //есть массив, и есть число которое нужно удалить из это массива, и потом вывести этот массив на экран уже без этого числа (чисел)
    public static void removeNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        int len = scanner.nextInt();
        int[] num = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            num[i] = random.nextInt(15);
        }
        System.out.println(Arrays.toString(num));
        ArrayList<Integer> nun1 = new ArrayList<Integer>();

        System.out.print("Which number to remove?: ");
        int delNumber = scanner.nextInt();
        for (int i = 0; i < num.length; i++) {
            if (num[i] != delNumber) {
                nun1.add(num[i]);
            }

        }
        for (int i = 0; i < nun1.size(); i++)
            System.out.print(nun1.get(i) + " ");
    }
}






