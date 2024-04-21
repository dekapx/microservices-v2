package com.dekapx.java.algorithms;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        char[] chars = new char[input.length()];
        for (int i = input.length() - 1; i > -1; i--) {
            System.out.print(input.charAt(i));
        }
    }
}
