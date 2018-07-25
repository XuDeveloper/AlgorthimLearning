package com.xu.math_and_bit_manipulation;

/**
 * https://blog.csdn.net/DERRANTCM/article/details/47745445
 */
public class Single_Number_II_137 {

    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            for (int n : nums) {
                if (((n >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result = result | ((count[i] % 3) << i);
        }
        return result;
    }

}
