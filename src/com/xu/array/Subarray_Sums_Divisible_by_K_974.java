package com.xu.array;

public class Subarray_Sums_Divisible_by_K_974 {

    // https://www.jianshu.com/p/7d9479ffcd5a
    // Time Limit Exceeded
    // 可以参考sum[i]的思路
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int[] sum = new int[len];
        for (int i = 0; i < len; i++) {
            sum[i] = (i == 0 ? 0: sum[i - 1]) + A[i];
        }
        int res = 0;
        if (sum[0] % K == 0) {
            res++;
        }
        for (int i = 1; i < len; i++) {
            if (sum[i] % K == 0) {
                res++;
            }
            for (int j = i - 1; j >= 0; j--) {
                if ((sum[i] - sum[j]) % K == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraysDivByK1(int[] A, int K) {
        int len = A.length;
        int[] mod = new int[K];
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            curSum += A[i];
            // 防止为负数
            mod[((curSum % K) + K) % K]++;
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            if (mod[i] > 1) {
                ans += (mod[i] * (mod[i] - 1)) / 2;
            }
        }
        ans += mod[0];
        return ans;
    }

}
