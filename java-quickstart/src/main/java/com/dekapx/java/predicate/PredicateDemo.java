package com.dekapx.java.predicate;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PredicateDemo {
    private static final IntPredicate isPrime = num -> num % 2 == 0;

    public static void main(String[] args) {
        IntStream.range(1, 10)
                .filter(isPrime)
                .forEach(System.out::println);
    }
}
