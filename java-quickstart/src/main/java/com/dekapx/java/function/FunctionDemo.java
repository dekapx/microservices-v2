package com.dekapx.java.function;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println(sayHello.apply("Java"));
        System.out.println(sayHello2.apply("Java"));
        System.out.println(findLength.apply("Test"));
    }

    private static final Function<String, String> sayHello = arg -> "Hello ! " + arg;
    private static final UnaryOperator<String> sayHello2 = arg -> "Hello ! " + arg;
    private static final Function<String, Integer> findLength = (arg)
            -> Objects.nonNull(arg) ? arg.length() : 0;
}
