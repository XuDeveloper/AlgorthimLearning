package com.xu.basic;

/**
 * 插入排序
 */

public class InsertSort {

    public void sort(int[] vals) {
        int len = vals.length;
        for (int i = 1; i < len; i++) {
            //拎出来当前未排序的这样牌
            int temp = vals[i];
            int j = 0;
            for (j = i - 1; j >= 0 && vals[j] > temp; j--) {
                vals[j + 1] = vals[j];
            }
            vals[j + 1] = temp;
        }
    }

}
