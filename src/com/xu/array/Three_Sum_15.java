package com.xu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_15 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            // c is always the last in a bunch of duplicates
            if (i + 1 < n && nums[i + 1] == nums[i]) {
                continue;
            }

            // want to find all pairs of A[j]+A[k]=-A[i], such that
            // j < k < i
            twoSum(nums, i - 1, -nums[i]);
        }
        return results;
    }

    private void twoSum(int[] A, int right, int S) {
        int i, j;
        j = right;
        for (i = 0; i <= right; ++i) {
            // A[i] must be the first in its duplicates
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            while (j > i && A[j] > S - A[i]) {
                --j;
            }

            if (i >= j) {
                break;
            }

            if (A[i] + A[j] == S) {
                List<Integer> t = new ArrayList<>();
                t.add(A[i]);
                t.add(A[j]);
                t.add(-S); // t.add(A[right+1])
                results.add(t);
            }
        }
    }

}
