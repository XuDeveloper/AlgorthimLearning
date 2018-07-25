package com.xu.offer;

public class Inverse_Pairs_36 {

    private int reversePair = 0;

    public int count(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        mergeSort(A, 0, A.length - 1);
        return reversePair;
    }

    public void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, mid + 1, end);
        }
    }

    public void merge(int[] A, int start1, int end1, int start2, int end2) {
        int len = end2 - start1 + 1;
        int[] anx = new int[len];
        int k = end2 - start1 + 1;

        int i = end1;
        int j = end2;

        while (i >= start1 && j >= start2) {
            if (A[i] > A[j]) {
                anx[--k] = A[i];
                i--;
                reversePair = reversePair + j - start2 + 1;
            } else {
                anx[--k] = A[j];
                j--;
            }
        }

        for (; i >= start1; i--)
            anx[--k] = A[i];
        for (; j >= start2; j--)
            anx[--k] = A[j];

        for (int m = 0; m < len; m++)
            A[start1++] = anx[m];

    }

}
