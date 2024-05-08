package com.dekapx.java.challenges.basics;

import java.util.stream.IntStream;

/**
 * Perform Binary Search
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int value = 2;
        int[] elements = IntStream.rangeClosed(1, 10).toArray();
        int index = binarySearch(elements, value);
        System.out.println(STR."Value: [\{value}] found at index: \{index}");
    }

    private static int binarySearch(int[] elements, int value) {
        int left = 0;
        int right = elements.length -1;

        while(left <= right) {
            int mid = (left + right)/2;
            if (elements[mid] == value) {
                return mid;
            } else if (elements[mid] < value) {
                left = mid + 1;
            } else if (elements[mid] > value) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
