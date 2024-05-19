package com.dekapx.java.challenges.basics;

public class ArrayEquilibriumIndex {
    public static void main(String[] args) {
        int[] array = {-7, 1, 5, 2, -4, 3, 0};
        int index = findEquilibriumIndex(array);
        System.out.println(STR."Equilibrium Index: \{index}");
    }

    private static int findEquilibriumIndex(int[] array) {
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            rightSum = totalSum - leftSum - array[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }
}
