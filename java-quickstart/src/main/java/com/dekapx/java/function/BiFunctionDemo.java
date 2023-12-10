package com.dekapx.java.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BiFunctionDemo {
    public static void main(String[] args) {
        System.out.println(concat.apply("Hello", "Java"));
        System.out.println(concat2.apply("Hello", "Java"));
    }

    private static final BiFunction<String, String, String> concat = (arg1, arg2)
            -> arg1 + " - " + arg2;

    private static final BinaryOperator<String> concat2 = (arg1, arg2)
            -> arg1 + " - " + arg2;
}
