package com.xu.math_and_bit_manipulation;

public class Palindrome_Number_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int mod = 1000000000;
        while (x / mod == 0 && mod > 1) {
            mod /= 10;
        }
        while (mod > 1) {
            if (x / mod != x % 10) {
                return false;
            }
            x = (x % mod) / 10;
            mod /= 100;
        }
        return true;
    }

}
