package com.xu.basic;

/**
 * 总览
 * https://juejin.im/post/5a96d6b15188255efc5f8bbd
 *
 * 冒泡排序
 * https://syzq.github.io/2017/08/04/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/
 */
public class BubbleSort {

    public void bubbleSort(int[] vals) {
        int len = vals.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (vals[j] > vals[j + 1]) {
                    vals[j] = vals[j] + vals[j + 1];
                    vals[j + 1] = vals[j] - vals[j + 1];
                    vals[j] = vals[j] - vals[j + 1];
                }
            }
        }
    }

}
