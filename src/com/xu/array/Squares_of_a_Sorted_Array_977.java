package com.xu.array;

public class Squares_of_a_Sorted_Array_977 {

    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int r = 0;
        while (r < N && A[r] < 0) {
            r++;
        }
        int l = r - 1;
        int[] res = new int[N];
        int i = 0;
        while (l >= 0 && r < N) {
            if (A[l] * A[l] < A[r] * A[r]) {
                res[i] = A[l] * A[l];
                l--;
            } else {
                res[i] = A[r] * A[r];
                r++;
            }
            i++;
        }
        while (l >= 0) {
            res[i] = A[l] * A[l];
            i++;
            l--;
        }
        while (r < N) {
            res[i] = A[r] * A[r];
            i++;
            r++;
        }
        return res;
    }

}
