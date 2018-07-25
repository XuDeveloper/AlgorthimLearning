package com.xu.array;

import java.util.Arrays;

/**
 * http://www.cnblogs.com/grandyang/p/7098764.html
 */

public class Task_Scheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] alphaNums = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            alphaNums[tasks[i] - 'A']++;
        }
        Arrays.sort(alphaNums);
        int i = 25;
        int max = alphaNums[25];
        int len = tasks.length;
        while (i >= 0 && alphaNums[i] == max) {
            i--;
        }
        return Math.max(len, (max - 1) * (n + 1) + 25 - i);
    }
}
