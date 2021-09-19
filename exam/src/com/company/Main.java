package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    //закомментированы промежуточные выводы вспомогательных материалов

    public static <sizeAll> void main(String[] args) throws IOException, InterruptedException {
        System.out.println(" Input Threads number");
        Scanner scanner = new Scanner(System.in);
        String nThreads =  scanner.nextLine();
        String path="d:\\ITMO\\java\\Downloader\\linksInput.txt";
        String dir="d:\\ITMO\\java\\Downloader\\DownloaderOutput";

        //Не очень понимаю, как здесь работать с командной строкой, поэтому создала свою строку аргументов
        String[] argument=new String[]{ nThreads, dir,path};

        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(argument[0]));
        Parser parser = new Parser();
        List<String> list = parser.parse(argument[2]);
        parser.workWithMap(list);
        Map<String, List<String>> mapURL = parser.map;
        System.out.println("Map содержит " + mapURL.size() + " элементов.");
        System.out.println("Доступно процессоров: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Рабочих потоков: " + nThreads );
        System.out.println();
        long startTime = System.nanoTime();

        mapURL.forEach((key, value) -> {
            executor.submit(new Download(key, value, argument[1])); //submit ставит задачу в очередь на выполнение
        });
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);// ждем пока все задачи не завершат выполнение
        System.out.println();
        long time = (System.nanoTime() - startTime)/ 1000000;
        double seconds = ((time / 1000.0) % 60);
        System.out.printf("Загружено: " + mapURL.size() + " файлов, %.5f MB\n", Parser.sizeAll );
        System.out.println("Время: " + seconds + " секунд");
        System.out.printf("Средняя скорость выполнения задания: %.3f kB/s\n", (Parser.sizeAll * 1024) / seconds);
        System.out.printf("Средняя скорость работы потоков: %.3f kB/s\n", ((Parser.sizeAll * 1024) / (Parser.secAll)));
    }
}
