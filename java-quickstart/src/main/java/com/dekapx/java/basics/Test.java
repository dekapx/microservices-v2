package com.dekapx.java.basics;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {
        String str = "Hello World";
        Consumer<String> c = arg -> System.out.println(arg);
        c.accept(str);

        Supplier<String> s = () -> str;
        System.out.println(s.get());

        UnaryOperator<Integer> sqrt = num -> num * num;
        System.out.println(sqrt.apply(5));

        BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
        System.out.println(sum.apply(5, 7));
    }
}
