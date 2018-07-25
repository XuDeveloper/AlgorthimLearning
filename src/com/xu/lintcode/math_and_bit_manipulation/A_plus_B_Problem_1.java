package com.xu.lintcode.math_and_bit_manipulation;

public class A_plus_B_Problem_1 {

    public int aplusb(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

}
