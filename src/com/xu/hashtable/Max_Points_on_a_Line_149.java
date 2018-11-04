package com.xu.hashtable;

import java.util.HashMap;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Max_Points_on_a_Line_149 {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // 键：斜率，值：个数
            int duplicate = 1;
            int vertical = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x) {
                        if (points[i].y == points[j].y) {
                            duplicate++;
                        } else {
                            vertical++;
                        }
                    } else {
                        // 精度会产生问题！
                        // 如testcase 是[[0,0],[94911151,94911150],[94911152,94911151]]
                        // 系统会把94911150/94911151和94911152/94911151当成同一个数。
                        double scope = points[i].y == points[j].y ? 0.0
                                : (1.0 * (points[j].y - points[i].y))
                                / (points[j].x - points[i].x);
                        if (!map.containsKey(scope)) {
                            map.put(scope, 1);
                        } else {
                            map.put(scope, map.get(scope) + 1);
                        }
                    }
                }
            }
            for (Integer count: map.values()) {
                if (count + duplicate > max) {
                    max = count + duplicate;
                }
            }
            max = Math.max(max, duplicate + vertical);
            map.clear();
        }
        return max;
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
