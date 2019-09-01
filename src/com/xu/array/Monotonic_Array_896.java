package com.xu.array;

public class Monotonic_Array_896 {

    public boolean isMonotonic(int[] A) {
        boolean isIncrease = true;
        boolean isDecrease = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                isDecrease = false;
            }
            if (A[i] < A[i - 1]) {
                isIncrease = false;
            }
        }
        return isDecrease || isIncrease;
    }

}
