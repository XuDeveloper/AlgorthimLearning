package com.xu.dp;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profitFront = new int[prices.length];
        profitFront[0] = 0;
        int lower = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profitFront[i] = Math.max(profitFront[i - 1], prices[i] - lower);
            lower = Math.min(lower, prices[i]);
        }
        int[] profitBack = new int[prices.length];
        profitBack[prices.length - 1] = 0;
        int higher = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            profitBack[i] = Math.max(profitBack[i + 1], higher - prices[i]);
            higher = Math.max(prices[i], higher);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, profitFront[i] + profitBack[i]);
        }
        return profit;
    }

}
