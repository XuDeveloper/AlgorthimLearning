package com.xu.lintcode.math_and_bit_manipulation;

/**
 * Cracking The Coding Interview
 * https://algorithm.yuanbin.me/zh-hans/math_and_bit_manipulation/update_bits.html
 */
public class Update_Bits_179_CTCI {

    public int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1’s */
        // 1’s through position j, then 0’s
        if (j == 31)
            j = max;
        else
            j = (1 << (j + 1)) - 1;
        int left = max - j;
        // 1’s after position i
        int right = ((1 << i) - 1);
        // 1’s, with 0s between i and j
        int mask = left | right;
        // Clear i through j, then put m in there
        return ((n & mask) | (m << i));
    }

}
