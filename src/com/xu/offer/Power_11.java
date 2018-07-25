package com.xu.offer;

public class Power_11 {

    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        double result = 0.0;
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }
        result = Power(base, exponent >> 1);
        result *= result;
        // 如果指数n为奇数，则要再乘一次底数base
        // 最后一位是1，与1相与得1，是奇数
        if ((n & 1) == 1)
            result *= base;
        // 如果指数为负数，则应该求result的倒数
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

}
