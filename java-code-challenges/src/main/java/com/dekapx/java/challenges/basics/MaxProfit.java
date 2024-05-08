package com.dekapx.java.challenges.basics;

/**
 * Find the max profit of stock prices
 * stockPrices = {2, 7, 5, 8, 1, 9, 6}
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] stockPrices = {2, 7, 5, 8, 1, 9, 6};
        int maxProfit = getMaxProfit(stockPrices);
        System.out.println(STR."MaxProfit: \{maxProfit}");
    }

    private static int getMaxProfit(int[] stockPrices) {
        int maxProfit = 0;

        for (int i = 0; i < stockPrices.length - 1; i ++) {
            for (int j = i + 1; j < stockPrices.length; j++) {
                int profit = stockPrices[j] - stockPrices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
