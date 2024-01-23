package com.dekapx.java.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return stepOne();
        });

        future.thenAccept(result -> stepTwo(result));
        future.get();
    }

    private static List<String> stepOne() {
        return List.of("Java", "Kotlin", "Python");
    }


    private static void stepTwo(List<String> elements) {
        for (String element: elements) {
            System.out.println(element);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
