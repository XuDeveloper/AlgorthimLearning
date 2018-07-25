package com.xu.offer;

public class Min_Numder_in_Rotated_Array_8 {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[low] == array[high] && array[low] == array[mid]) {
                return minInOrder(array, low, high);
            }
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] array, int low, int high) {
        int result = array[low];
        for (int i = low + 1; i < high; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

}

