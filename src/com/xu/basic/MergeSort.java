package com.xu.basic;

public class MergeSort {

    public void sort(int[] vals) {
        mergeSort(vals, 0, vals.length - 1);
    }

    public void mergeSort(int[] vals, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(vals, left, mid);
            mergeSort(vals, mid + 1, right);
            merge(vals, left, right, mid);
        }
    }

    public void merge(int[] vals, int left, int right, int mid) {
        int[] b = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (vals[i] < vals[j]) {
                b[k++] = vals[i++];
            } else {
                b[k++] = vals[j++];
            }
        }
        while (i <= mid) {
            b[k++] = vals[i++];
        }
        while (j <= right) {
            b[k++] = vals[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            vals[i] = b[k];
        }
    }

}
