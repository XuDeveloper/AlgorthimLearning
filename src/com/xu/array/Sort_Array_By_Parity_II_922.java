package com.xu.array;

public class Sort_Array_By_Parity_II_922 {

    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int n = A.length;
        int[] res = new int[n];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < n; i++) {
            if ((A[i] & 1) != 0) {
                res[odd] = A[i];
                odd = odd + 2;
            } else {
                res[even] = A[i];
                even = even + 2;
            }
        }
        return res;
    }

    public int[] sortArrayByParityII_1(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int n = A.length;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            while (i < n && (A[i] & 1) != 0) {
                i += 2;
            }
            while (j < n && (A[j] & 1) == 0) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
