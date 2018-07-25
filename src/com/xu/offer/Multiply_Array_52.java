package com.xu.offer;

public class Multiply_Array_52 {

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] forward = new int[len];
        int[] backward = new int[len];
        int[] B = new int[len];
        forward[0] = 1;
        backward[0] = 1;
        for (int i = 1; i < len; i++) {
            forward[i] = A[i - 1] * forward[i - 1];
            backward[i] = A[len - i] * backward[i - 1];
        }
        for (int i = 0; i < len; i++) {
            B[i] = forward[i] * backward[len - i - 1];
        }
        return B;
    }

}
