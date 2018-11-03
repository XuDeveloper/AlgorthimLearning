package com.xu.hashtable;

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
