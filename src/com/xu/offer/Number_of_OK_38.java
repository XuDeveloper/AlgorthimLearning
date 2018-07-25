package com.xu.offer;

public class Number_of_OK_38 {

    public int getNumberOfK(int[] array, int k) {
        int number = 0;
        if (array != null && array.length > 0) {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            if (first > - 1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midData = array[mid];
        if (midData == k) {
            if (mid > 0 && array[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(array, k, start, end);
    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midData = array[mid];
        if (midData == k) {
            if (mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(array, k, start, end);
    }

}

