package com.dekapx.java.consumer;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        String[] languages = {"Java", "Kotlin", "Python"};
        printElements.accept(languages);
    }

    private static final Consumer<String[]> printElements = (elements) -> {
        Arrays.stream(elements).forEach(System.out::println);
    };

}
