package com.xu.array;

public class Beautiful_Arrangement_II_667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        int i = 0;
        for (; i < k; i++) {
            if (i % 2 == 0) {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
        }
        if (i % 2 == 0) {
            for (int j = k; j < n; j++) {
                res[j] = right;
                right--;
            }
        } else {
            for (int j = k; j < n; j++) {
                res[j] = left;
                left++;
            }
        }
        return res;
    }
}
