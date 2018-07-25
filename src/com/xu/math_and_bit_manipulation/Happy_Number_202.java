package com.xu.math_and_bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number_202 {

    public boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = countSum(n);
            if (n == 1) {
                return true;
            } else if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    public int countSum(int n) {
        int sum = 0;
        for (; n > 0; n /= 10) {
            sum += (n % 10) * (n % 10);
        }
        return sum;
    }

}
