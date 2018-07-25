package com.xu.string;

public class String_to_Integer_atoi_8 {

    public int myAtoi(String str) {
        // 1. null or empty string
        if (str == null || str.length() == 0) return 0;

        // 2. whitespaces
        str = str.trim();

        // 3. +/- sign
        boolean isPositive = true;
        int i = 0;
        if (str.charAt(0) == '+') {
            isPositive = true;
            i++;
        } else if (str.charAt(0) == '-') {
            isPositive = false;
            i++;
        }

        double tmp = 0;
        // 4. calculate real value
        for (; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            if (digit < 0 || digit > 9) break;

            // 5. handle min & max
            if (isPositive) {
                tmp = 10 * tmp + digit;
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                tmp = 10 * tmp - digit;
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        int ret = (int)tmp;
        return ret;

    }

}
