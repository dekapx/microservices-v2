package com.dekapx.java.basics;

public class Test {
    public static void main(String[] args) {
        String numbers = "5483";
        for (int i = 0; i < numbers.length(); i ++) {
            int value = Character.getNumericValue(numbers.charAt(i));
            System.out.println(value);
        }
    }
}

