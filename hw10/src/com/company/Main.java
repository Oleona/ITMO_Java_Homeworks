package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
         ReadTextDisplayListStrings();
        System.out.println("");
        ReadTextDisplayListStrings1();
        String line2 = "А. и Б.Стругацкие. «Трудно быть богом». Там, где торжествует серость, к власти всегда приходят черные.";
        WritesToFileStringPermittedByParameter(line2);
        GlueTwoTextFiles();
        CopyFile();
        FindFilesWithSomeNameStringReturnNameList();
        FindTxtFilesWithSomeNameStringReturnNameList();


    }


    public static void ReadTextDisplayListStrings() {
        System.out.println("1. Написать метод, который читает текстовый файл и возвращает его в виде списка строк.");
        try (FileReader reader = new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);

            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    //Или, если нужно именно в массив строк
    public static void ReadTextDisplayListStrings1() throws IOException {
        System.out.println("1. вариант 2.  Написать метод, который читает текстовый файл и возвращает его в виде списка строк.");
        BufferedReader reader = new BufferedReader(new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test1.txt"));

        String line;
        List<String> lines1 = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines1.add(line);

        }
        System.out.println("--------------");
        for (String s : lines1) {
            System.out.println(s);
        }


    }

    public static void WritesToFileStringPermittedByParameter(String line2) throws IOException {
        System.out.println("2. Написать метод, который записывает в файл строку, переданную параметром.");
        boolean append = true;
        String filename = "d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test2.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append));
        writer.write(line2);
        writer.close();
        FileReader reader = new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test2.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }

    }

    public static void GlueTwoTextFiles() throws IOException {
        System.out.println("");
        System.out.println("3. Используя решение 1 и 2, напишите метод, который склеивает два текстовый файла в один.");
        List<Path> inputs = Arrays.asList(Paths.get("test1.txt"), Paths.get("test2.txt"));
        Path output = Paths.get("test3.txt");
        for (Path path : inputs) {
            List<String> lines = Files.readAllLines(path);
            Files.write(output, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        FileReader reader = new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test3.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void CopyFile() throws IOException {
        System.out.println("4. Написать метод для копирования файла (побайтно, или массивами байт).");

        FileInputStream fileIn = new FileInputStream("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test.txt");
        FileOutputStream fileOut = new FileOutputStream("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test4.txt");

        while (fileIn.available() > 0) {
            int oneByte = fileIn.read();
            fileOut.write(oneByte);
        }
        fileIn.close();
        fileOut.close();
        FileReader reader = new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw10\\test4.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }



    public static void FindFilesWithSomeNameStringReturnNameList() {
        System.out.println("");
        System.out.println("5. Написать метод, который в каталоге ищет файлы, в имени которых содержится определенная строка, " +
                "и который возвращает список имен таких файлов.");

        File folder = new File("d:\\ITMO\\java");
        for (File file : folder.listFiles()) {
            if (file.getName().contains("java"))
                System.out.println(file.getName());
        }
    }
    //В методе ниже я предположила, что искать нужно в названии файла, не в его содержимом
    public static void FindTxtFilesWithSomeNameStringReturnNameList() {
        System.out.println("6. Написать метод, который в каталоге ищет текстовые файлы," +
                " в которых содержится определенная строка, и который возвращает список имен таких файлов. (FilenameFilter)");

        File dir = new File("d:\\ITMO");

        File[] files = dir.listFiles((dir1, name) -> name.contains("l") && name.endsWith(".txt"));
        for (File file :  files) {

                System.out.println(file.getName());
        }
    }


}
