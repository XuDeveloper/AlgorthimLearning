package com.xu.hashtable;

// https://leetcode.com/problems/minimum-area-rectangle/solution/

import java.util.HashSet;
import java.util.Objects;

public class Minimum_Area_Rectangle_939 {

    public int minAreaRect(int[][] points) {
        // 将所有点存入set
        HashSet<Integer> set = new HashSet<>();
        for (int[] point: points) {
            // 40001 * x + y
            set.add(Objects.hash(point[0], point[1]));
        }
        int min = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x0 = points[i][0];
                int y0 = points[i][1];
                int x1 = points[j][0];
                int y1 = points[j][1];
                if (x0 == x1 || y0 == y1) {
                    continue;
                }
                // 对角线
                if (set.contains(Objects.hash(x0, y1)) && set.contains(Objects.hash(x1, y0))) {
                    min = Math.min(min, Math.abs(x0 - x1) * Math.abs(y0 - y1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }

}
