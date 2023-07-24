package com.practices.concepts.semaphore;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class PrintEvenOdd {

    private Semaphore semaphore = new Semaphore(1, true);

    public void printMsg(int number) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+":"+ number);
        semaphore.release();
    }
}


public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {

        PrintEvenOdd printEvenOdd = new PrintEvenOdd();

        CompletableFuture.runAsync(() -> {
            IntStream.rangeClosed(0,10).filter(x -> x%2 == 0).forEach(x -> printEvenOdd.printMsg(x));
        });

        CompletableFuture.runAsync(() -> {
            IntStream.rangeClosed(0,10).filter(x -> x%2 != 0).forEach(x -> printEvenOdd.printMsg(x));
        });
        Thread.sleep(2000);
    }
    }