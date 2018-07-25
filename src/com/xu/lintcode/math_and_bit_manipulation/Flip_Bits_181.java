package com.xu.lintcode.math_and_bit_manipulation;

public class Flip_Bits_181 {

    public int bitSwapRequired(int a, int b) {
        int count = 0;
        int temp = a ^ b;
        while (temp != 0) {
            count++;
            temp &= (temp - 1);
        }
        return count;
    }

}
