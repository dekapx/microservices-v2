package com.dekapx.java.concurrency;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureJoin {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()
                -> "Java is");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()
                -> "Great");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);

        allFutures.thenRun(() -> {
            String result1 = future1.join();
            String result2 = future2.join();
            System.out.println(new StringJoiner(" ").add(result1).add(result2));
        });
    }
}
