package com.dekapx.java.challenges.basics;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] elements = {2, 7, 5, 8, 1, 9, 6};
        printElements(sortElements(elements));
    }

    private static int[] sortElements(int[] elements) {
        for (int i = 0; i < elements.length; i ++) {
            for (int j = i; j < elements.length; j ++) {
                if (elements[i] > elements[j]) {
                    swap(elements, i, j);
                }
            }
        }
        return elements;
    }

    private static void swap(int[] elements, int i, int j) {
        int tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }


    private static void printElements(int[] elements) {
        Arrays.stream(elements).forEach(i -> System.out.print(STR."\{i} "));
    }
}
