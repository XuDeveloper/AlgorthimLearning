package com.xu.dp;

public class Longest_Turbulent_Subarray_978 {

    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length < 2) {
            return A.length;
        }
        int len = A.length;
        int dp = A[0] == A[1] ? 1 : 2;
        int res = dp;
        for (int i = 3; i <= len; i++) {
            if ((A[i - 3] < A[i - 2] && A[i - 2] > A[i - 1]) || (A[i - 3] > A[i - 2] && A[i - 2] < A[i - 1])) {
                dp = dp + 1;
                res = Math.max(dp, res);
            } else if (A[i - 1] == A[i - 2]) {
                dp = 1;
            } else {
                dp = 2;
            }
        }
        return res;
    }

    public int maxTurbulenceSize2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length < 2) {
            return A.length;
        }
        //skip sanity check
        boolean prevDes = true;// this means previous interval
        //is desecanding
        int length = 1;
        int maxLength = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (prevDes) {
                    length++;
                    prevDes = false;
                }
                else {
                    length = 2;
                }
            }
            else if (A[i] < A[i - 1]){
                if (!prevDes) {
                    length++;
                    prevDes = true;
                }
                else {
                    length = 2;
                }
            }
            else {
                length = 1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

}
