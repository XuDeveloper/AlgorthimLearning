package com.xu.hashtable;

import java.util.HashMap;

public class Number_of_Boomerangs_447 {

    public int numberOfBoomerangs(int[][] points) {
        // 查找表
        // 思路：i到j的距离等于i到k的距离，所以i作为中枢点，键为距离，值为相同距离的个数
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int temp = dis(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (!map.containsKey(temp)) {
                        map.put(temp, 1);
                    } else {
                        map.put(temp, map.get(temp) + 1);
                    }
                }
            }
            for (Integer k: map.values()) {
                if (k >= 2) {
                    // 排列组合相关
                    res += k * (k - 1);
                }
            }
        }
        return res;
    }

    private int dis(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}
