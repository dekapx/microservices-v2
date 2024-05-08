package com.dekapx.java.challenges.basics;

/**
 * Perform sum of large numbers
 * 12345
 * 01238
 * -----
 * 13583
 * -----
 */
public class LargeNumbersSum {
    public static void main(String[] args) {
        String expr1 = "12345";
        String expr2 = "01238";
        String sum = calculate(expr1, expr2);
        System.out.println(sum);
    }

    private static String calculate(String expr1, String expr2) {
        String sum = "";
        int curry = 0;

        for (int i = expr1.length() - 1; i >= 0; i--) {
            int num1 = expr1.charAt(i) - '0';
            int num2 = expr2.charAt(i) - '0';
            int result = num1 + num2 + curry;
            sum = result % 10 + sum;
            curry = result / 10;
        }

        return sum;
    }
}
