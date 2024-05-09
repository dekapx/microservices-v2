package com.dekapx.java.challenges.basics;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] elements = {2, 7, 5, 8, 1, 9, 6};

        printElements(elements);
    }

    private static void printElements(int[] elements) {
        Arrays.stream(elements).forEach(i -> System.out.print(STR."\{i} "));
    }
}
