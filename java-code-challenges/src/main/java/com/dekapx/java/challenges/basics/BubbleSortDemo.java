package com.dekapx.java.challenges.basics;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] elements = {2, 7, 5, 8, 1, 9, 6};
        printElements(sortElements(elements));
    }

    private static int[] sortElements(int[] elements) {
        boolean flag = false;
        for (int i = 0; i < elements.length; i ++) {
            for (int j = 0; j < elements.length - 1; j ++) {
                if (elements[j] > elements [j + 1]) {
                    swap(elements, j);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return elements;
    }

    private static void swap(int[] elements, int index) {
        final int temp = elements[index];
        elements[index] = elements[index + 1];
        elements[index + 1] = temp;
    }

    private static void printElements(int[] elements) {
        Arrays.stream(elements).forEach(i -> System.out.print(STR."\{i} "));
    }
}
