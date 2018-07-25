package com.xu.array;

/**
 * http://blog.csdn.net/mupengfei6688/article/details/78665547
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return Math.max(cash, hold);
    }

}
