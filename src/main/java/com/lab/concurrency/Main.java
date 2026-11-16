package com.lab.concurrency;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        UnsafeCounter counter = new UnsafeCounter();

        Thread[] threads = new Thread[1000];

        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 1000; j++){
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for(int i = 0; i < 1000; i++){
            threads[i].join();
        }
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}