package com.xu.offer;

public class Reorder_Array_14 {

    public void reOrderArray(int[] array) {
        int length = array.length;
        if (length == 0) {
            return;
        }
        int[] des = new int[length];
        mergeSort(array, des, 0, length - 1);
    }

    public void mergeSort(int[] array, int[] result, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, result, left, mid);
            mergeSort(array, result, mid + 1, right);
            merge(array, result, left, right, mid);
        }
    }

    public void merge(int[] array, int[] result, int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && (array[i] & 1) == 1) {
            result[k++] = array[i++];
        }
        while (j <= right && (array[j] & 1) == 1) {
            result[k++] = array[j++];
        }
        while (i <= mid) {
            result[k++] = array[i++];
        }
        while (j <= right) {
            result[k++] = array[j++];
        }
        for (int l = left; l <= right; l++) {
            array[l] = result[l];
        }
    }

}
