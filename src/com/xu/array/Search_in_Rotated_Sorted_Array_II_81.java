package com.xu.array;

public class Search_in_Rotated_Sorted_Array_II_81 {

    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (A[mid] == target) return true;

            if (A[mid] > A[lb]) {
                // case1: numbers between lb and mid are sorted
                if (A[lb] <= target && target <= A[mid]) {
                    ub = mid;
                } else {
                    lb = mid;
                }
            } else if (A[mid] < A[lb]) {
                // case2: numbers between mid and ub are sorted
                if (A[mid] <= target && target <= A[ub]) {
                    lb = mid;
                } else {
                    ub = mid;
                }
            } else {
                // case3: A[mid] == target
                lb++;
            }
        }

        if (target == A[lb] || target == A[ub]) {
            return true;
        }
        return false;
    }

}
