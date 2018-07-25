package com.xu.offer;

import java.util.ArrayList;

public class Least_K_30 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0) {
            return result;
        }
        int low = 0;
        int high = input.length - 1;
        int index = Partition(input, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = Partition(input, low, high);
            } else {
                low = index + 1;
                index = Partition(input, low, high);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public int Partition(int[] input, int low, int high) {
        int temp = input[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (input[i] <= temp && i <= high) {
                i++;
            }
            while (input[j] > temp) {
                j--;
            }
            if (i < j) {
                swap(input, i, j);
            }
        }
        input[low] = input[j];
        input[j] = temp;
        return i;
    }

    private void swap(int[] input, int low, int high) {
        int temp = input[high];
        input[high] = input[low];
        input[low] = temp;
    }

    // 可使用TreeSet 或 堆

}
