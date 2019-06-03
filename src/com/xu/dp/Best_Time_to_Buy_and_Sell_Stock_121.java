package com.xu.dp;

// 刷过1次 （2019.06.01 ）

public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int profit = 0;
        int curPriceMin = Integer.MAX_VALUE;
        for (int price : prices) {
            profit = Math.max(profit, price - curPriceMin);
            curPriceMin = Math.min(curPriceMin, price);
        }

        return profit;
    }

    public int maxProfit_dp(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit[i] = Math.max(profit[i - 1], prices[i] - min);
        }
        return profit[prices.length - 1];
    }
}
