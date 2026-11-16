package com.lab.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PoolCounter counter = new PoolCounter();

        // Create a fixed thread pool with 8 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(8);

        // Submit 1,000 tasks, each incrementing 1,000 times (Total: 1,000,000 operations)
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }

        // Tell the executor to stop accepting new tasks and wait for existing ones to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final Thread Pool Counter Value: " + counter.getCount());
    }
}
