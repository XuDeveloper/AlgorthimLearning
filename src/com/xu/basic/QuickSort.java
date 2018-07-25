package com.xu.basic;

public class QuickSort {

    public void sort(int[] vals) {
        quicksort(vals, 0, vals.length - 1);
    }

    public void quicksort(int[] vals, int left, int right) {
        if (left < right) {
            int p = partition(vals, left, right);
            quicksort(vals, left, p - 1);
            quicksort(vals, p + 1, right);
        }
    }

    public int partition(int[] vals, int left, int right) {
        int x = vals[left];
        int i = left;
        int j = right;
        while (i <= j) {
            while (i <= right && vals[i] <= x) {
                i++;
            }
            while (vals[j] > x) {
                j--;
            }
            if (i < j) {
                vals[i] = vals[i] + vals[j];
                vals[j] = vals[i] - vals[j];
                vals[i] = vals[i] - vals[j];
            }
        }
        vals[left] = vals[j];
        vals[j] = x;
        return j;
    }

}
