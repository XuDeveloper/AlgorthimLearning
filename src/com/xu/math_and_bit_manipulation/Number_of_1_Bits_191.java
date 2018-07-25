package com.xu.math_and_bit_manipulation;

public class Number_of_1_Bits_191 {

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int i = 0;
        while (n != 0) {
            n = n & (n - 1);
            i++;
        }
        return i;
    }

}
