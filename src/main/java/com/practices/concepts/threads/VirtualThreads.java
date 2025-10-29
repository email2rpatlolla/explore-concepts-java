package com.practices.concepts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        traditionalThreads();
        virtualThreads();
    }

    public static void traditionalThreads() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100); // Limited pool
        var currTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000); // Simulate blocking task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(100); // wait for all tasks to finish
        }
        System.out.println("traditionalThreads time: "+ (System.currentTimeMillis() - currTime));
    }

    public static void virtualThreads() {
        var currTime = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000); // Still blocking call, but handled efficiently
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
        System.out.println("virtualThreads time: "+ (System.currentTimeMillis() - currTime));
    }
}
