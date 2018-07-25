package com.xu.lintcode.array;

import java.util.ArrayList;

public class Merge_Two_Sorted_Arrays_6 {

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        ArrayList<Integer> C = new ArrayList<>();
        int aLen = A.length, bLen = B.length;
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            if (A[i] > B[j]) {
                C.add(B[j]);
                j++;
            } else {
                C.add(A[i]);
                i++;
            }
        }
        while (i < aLen) {
            C.add(A[i]);
            i++;
        }
        while (j < bLen) {
            C.add(B[j]);
            j++;
        }
        int[] result = new int[C.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] =  C.get(k);
        }
        return result;
    }

}
