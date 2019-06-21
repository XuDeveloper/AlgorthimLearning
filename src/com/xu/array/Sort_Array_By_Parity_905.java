package com.xu.array;

public class Sort_Array_By_Parity_905 {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) != 0) {
                res[end--] = A[i];
            } else {
                res[start++] = A[i];
            }
        }
        return res;
    }

}
