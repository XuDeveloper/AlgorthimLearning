package com.xu.array;

// https://blog.csdn.net/camellhf/article/details/52824234

public class Arithmetic_Slices_413 {

    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }

}
