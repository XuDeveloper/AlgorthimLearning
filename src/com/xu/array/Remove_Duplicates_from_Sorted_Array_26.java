package com.xu.array;

public class Remove_Duplicates_from_Sorted_Array_26 {

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }

}
