package com.dekapx.java.challenges.basics;

import java.util.stream.IntStream;

public class PrintElements {
    public static void main(String[] args) {
        printItems(10);
    }

    private static void printItems(int n) {
        IntStream.range(0, n)
                .forEach(System.out::println);
    }
}
