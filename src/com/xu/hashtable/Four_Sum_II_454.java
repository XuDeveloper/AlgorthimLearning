package com.xu.hashtable;

import java.util.HashMap;

// 刷过1遍（2019.08.06 ）

public class Four_Sum_II_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a: A) {
            for (int b: B) {
                int sumAB = a + b;
                if (!map.containsKey(sumAB)) {
                    map.put(sumAB, 1);
                } else {
                    map.put(sumAB, map.get(sumAB) + 1);
                }
            }
        }
        for (int c: C) {
            for (int d: D) {
                int sumCD = c + d;
                if (map.containsKey(-sumCD)) {
                    res += map.get(-sumCD);
                }
            }
        }
        return res;
    }

}
