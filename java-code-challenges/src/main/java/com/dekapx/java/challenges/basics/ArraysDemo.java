package com.dekapx.java.challenges.basics;

import java.util.stream.IntStream;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] elements = {4, 8, 3, 7, 1, 9};
        traverse(elements);
        System.out.println("");
        int number = 3;
        int index = findIndex(elements, number);
        System.out.println(STR."Number: \{number} found at index: \{index}");
    }

    private static void traverse(int[] elements) {
        IntStream.range(0, elements.length)
                .forEach(i -> System.out.print(elements[i]));
    }

    private static int findIndex(int[] elements, int number) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (number == elements[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
