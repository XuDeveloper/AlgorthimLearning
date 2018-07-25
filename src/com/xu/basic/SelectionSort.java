package com.xu.basic;

/**
 * 选择排序
 * http://blog.csdn.net/q6834850/article/details/72180131
 */
public class SelectionSort {

    public void sort(int[] vals) {
        int len = vals.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (vals[j] < vals[min]) {
                    min = j;
                }
            }
            if (min != i) {
                vals[i] = vals[i] + vals[min];
                vals[min] = vals[i] - vals[min];
                vals[i] = vals[i] - vals[min];
            }
        }
    }

}
