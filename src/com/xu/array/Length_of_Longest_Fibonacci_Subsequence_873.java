package com.xu.array;

import java.util.HashSet;

public class Length_of_Longest_Fibonacci_Subsequence_873 {

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int len = A.length;
        int max = 2;
        for (int i = 0; i < len; i++) {
            set.add(A[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int a1 = A[i], a2 = A[j];
                int curMax = 2;
                while (set.contains(a1 + a2)) {
                    curMax++;
                    int temp = a1;
                    a1 = a2;
                    a2 = temp + a2;
                }
                max = Math.max(max, curMax);
            }
        }
        return max == 2 ? 0 : max;
    }

}
