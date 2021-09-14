package com.company;

import java.util.Arrays;

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s START \n", Thread.currentThread().getName());
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 101; i++) {
            System.out.printf("%s print %d ,", name, i);
        }
        System.out.print(" \n");
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("After run\" " + Thread.currentThread().getState() + "\" state.");
    }
}

class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}

class MyThread2 implements Runnable {

    Counter counter;

    MyThread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void run() {
        synchronized (counter) {
            String name = "";
            //закомментирован вспомогательный код, помогавший в отладке
            // String name = Thread.currentThread().getName();
            // System.out.printf("%s START \n", name);
            for (int i = 1; i < 1001; i++) {
                name = Thread.currentThread().getName();
                counter.increment();
                System.out.printf("currentThread name %s  count %d \n", name, counter.getCount());
                //  System.out.printf("%s count= %d \n ", name, i);
            }
            System.out.println("stream  " + name + "  count " + counter.getCount());
        }
    }
}

class MyThread3 implements Runnable {
    private String name;
    private Object lock;

    public MyThread3(Object object, String name) {
        this.lock = object;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println("Stream name " + name);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("MyThread has error");
                }
            }
        }
    }
}

public class Main {
    public static void ThreadState(Thread thread) {
        System.out.println("thread  \"" + thread.getState() + "\" state.");
    }

    public static void main(String[] args) throws InterruptedException {

        //Закомментировано чтобы было нагляднее в консоли видно выполнение следующих задач
        // System.out.println("1.Напишите программу, в которой запускается 10 потоков и каждый из них выводит\n" +
        //         "числа от 0 до 100.\n");

        // for(int i=1; i < 11; i++){
        // new MyThread("MyThread " + i).start(); }


        //Закомментировано чтобы было нагляднее в консоли видно выполнение следующих задач
        // System.out.println("2.Выведете состояние потока перед его запуском, после запуска и во время\n" +
        //        "выполнения.\n");

        //Thread t1 = new Thread(new MyThread1());
        // ThreadState(t1);
        //t1.start();
        // ThreadState(t1);
        // Thread.sleep(100);
        // ThreadState(t1);

        //Закомментировано чтобы было нагляднее в консоли видно выполнение следующих задач
        /*System.out.println("3.Напишите программу, в которой запускается 100 потоков, каждый из которых\n" +
                "вызывает метод increment() 1000 раз.\n" +
                "После того, как потоки завершат работу, проверьте, чему равен count .\n" +
                "Если обнаружилась проблема, предложите ее решение");
        Counter mycounter = new Counter();
        for (int i = 0; i < 100; i++) {
            Thread t2 = new Thread(new MyThread2(mycounter));
            t2.start();
        }*/

        System.out.println("4. Напишите программу, в которой создаются два потока, каждый из которых выводит\n" +
                "по очереди на консоль своё имя.");
        Object lock = new Object();
        MyThread3 t3 = new MyThread3(lock, "start");
        MyThread3 t4 = new MyThread3(lock, "finish");
        new Thread(t3).start();
        new Thread(t4).start();
    }
}

