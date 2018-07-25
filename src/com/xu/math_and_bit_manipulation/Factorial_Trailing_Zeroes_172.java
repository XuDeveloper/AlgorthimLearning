package com.xu.math_and_bit_manipulation;

public class Factorial_Trailing_Zeroes_172 {

    public int trailingZeroes(int n) {
        if (n < 0) {
            return -1;
        }

        int count = 0;
        for (; n > 0; n /= 5) {
            count += (n / 5);
        }

        return count;
    }

}
