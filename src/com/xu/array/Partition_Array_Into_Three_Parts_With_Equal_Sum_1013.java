package com.xu.array;

public class Partition_Array_Into_Three_Parts_With_Equal_Sum_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int leftSum = 0, midSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (leftSum == sum / 3) {
                if (midSum == sum / 3) {
                    return true;
                } else {
                    midSum += A[i];
                }
            } else {
                leftSum += A[i];
            }
        }
        return false;
    }

}
