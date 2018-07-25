package com.xu.offer;

public class Max_Subarray_31 {

    public int FindGreatestSumOfSubArray(int[] array) {
        // 解法一参考leetcode-53

        if (array.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        //动态规划，主要是找到状态转移方程
        //设f(j)是从s[0]到s[j]最大和
        //f(j) = max(s[j], f[j-1]+s[j])
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            result = Math.max(result, sum);
        }
        return result;
    }

}
