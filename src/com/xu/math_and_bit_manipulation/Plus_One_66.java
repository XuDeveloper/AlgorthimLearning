package com.xu.math_and_bit_manipulation;

public class Plus_One_66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int[] result = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry == 1) {
            int[] newresult = new int[result.length + 1];
            System.arraycopy(result, 0, newresult, 1, result.length);
            newresult[0] = 1;
            return newresult;
        }
        return result;
    }

}
