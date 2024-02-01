package com.dekapx.java.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChain {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApplyAsync(result -> multiply(result, 2))
                .thenApplyAsync(result -> add(result, 5));

        future.thenAccept(result -> print(result));
    }

    private static Integer add(Integer arg, Integer value) {
        return arg + value;
    }

    private static Integer multiply(Integer arg, Integer value) {
        return arg * value;
    }

    private static void print(Integer arg) {
        System.out.println(arg);
    }
}
