package com.xu.math_and_bit_manipulation;

public class Counting_Bits_338 {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            int half = i >> 1;
            if (i % 2 == 0) {
                result[i] = result[half];
            } else {
                result[i] = result[half] + 1;
            }
        }
        return result;
    }

}
