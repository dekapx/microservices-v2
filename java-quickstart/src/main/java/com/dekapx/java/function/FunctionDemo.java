package com.dekapx.java.function;

import java.util.Objects;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println(countLength.apply("Test"));
    }

    private static final Function<String, Integer> countLength = (arg)
            -> Objects.nonNull(arg) ? arg.length() : 0;
}
