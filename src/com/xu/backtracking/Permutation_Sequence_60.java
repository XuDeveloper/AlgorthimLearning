package com.xu.backtracking;

import java.util.LinkedList;
import java.util.List;

// 刷过1遍（2019.08.25 ）

/**
 * https://blog.csdn.net/u012848330/article/details/52741442
 */

public class Permutation_Sequence_60 {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] array = new int[n + 1];
        int sum = 1;
        array[0] = 1;

        // array[] = [1, 1, 2, 6, 24, ... , n!] 阶乘数组
        for (int i = 1; i <= n; i++) {
            sum *= i;
            array[i] = sum;
        }

        // nums[] = [1, 2, 3, ... n]
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / array[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k % array[n - i];
        }
        return sb.toString();
    }
}
