package com.dekapx.java.challenges.basics;

import java.util.stream.IntStream;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int value = 7;
        int[] elements = IntStream.rangeClosed(1, 10).toArray();
        int index = binarySearch(elements, value);
        System.out.println(STR."Value: [\{value}] found at index: \{index}");
    }

    private static int binarySearch(int[] elements, int value) {
        int elementIndex = -1;
        int lowerBound = 0;
        int upperBound = elements.length - 1;

        while(lowerBound <= upperBound) {
            int midpoint = (upperBound + lowerBound) / 2;
            if (value == elements[midpoint]) {
                elementIndex = midpoint;
                break;
            } else if (value < midpoint) {
                upperBound = midpoint - 1;
            } else if (value > midpoint) {
                lowerBound = midpoint + 1;
            }
        }

        return elementIndex;
    }
}
