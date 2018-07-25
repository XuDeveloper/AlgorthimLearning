package com.xu.binary_search;

public class Median_of_Two_Sorted_Arrays_4 {

    public double findMedianSortedArrays(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return -1.0;
        }
        int lenA = (A == null) ? 0 : A.length;
        int lenB = (B == null) ? 0 : B.length;
        int len = lenA + lenB;

        // return median for even and odd cases
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len/2 + 1);
        }
    }

    private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {

        int lenA = (A == null) ? 0 : A.length;
        if (indexA > lenA - 1) {
            return B[indexB + k - 1];
        }
        int lenB = (B == null) ? 0 : B.length;
        if (indexB > lenB - 1) {
            return A[indexA + k - 1];
        }

        // avoid infilite loop if k == 1
        if (k == 1) return Math.min(A[indexA], B[indexB]);

        int keyA = Integer.MAX_VALUE, keyB = Integer.MAX_VALUE;
        if (indexA + k/2 - 1 < lenA) keyA = A[indexA + k/2 - 1];
        if (indexB + k/2 - 1 < lenB) keyB = B[indexB + k/2 - 1];

        if (keyA > keyB) {
            return findKth(A, indexA, B, indexB + k/2, k - k/2);
        } else {
            return findKth(A, indexA + k/2, B, indexB, k - k/2);
        }
    }

}
