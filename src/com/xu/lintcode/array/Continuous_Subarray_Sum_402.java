package com.xu.lintcode.array;

import java.util.ArrayList;
import java.util.List;

public class Continuous_Subarray_Sum_402 {

    public List<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        int first = 0, first2 = 0, last = 0;
        int sum = 0, minSum = 0, maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (minSum > sum) {
                sum = minSum;
                first2 = i;
            }
            sum += A[i];
            if (sum - minSum > maxSub) {
                maxSub = sum - minSum;
                last = i;
                if (first2 <= last) {
                    first = first2;
                }
            }
        }
        result.add(first);
        result.add(last);
        return result;
    }

}
