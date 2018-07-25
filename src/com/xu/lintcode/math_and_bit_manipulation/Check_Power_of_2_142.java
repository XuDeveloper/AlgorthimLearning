package com.xu.lintcode.math_and_bit_manipulation;

public class Check_Power_of_2_142 {

    public boolean checkPowerOf2(int n) {
        if (n < 1) {
            return false;
        } else {
            return (n & (n - 1)) == 0;
        }
    }

}
