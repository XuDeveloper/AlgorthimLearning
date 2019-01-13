package com.xu.array;

public class Kth_Largest_Element_in_an_Array_215 {

    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return findK(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int j = end;
        while (true) {
            while (nums[i] < pivot && i < j) {
                i++;
            }
            while (nums[j] >= pivot && j > i) {
                j--;
            }
            if (i == j) {
                break;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, end);
        if (k == i + 1) {
            return pivot;
        } else if (k < i + 1) {
            return findK(nums, k, start, i - 1);
        } else {
            return findK(nums, k, i + 1, end);
        }
    }

    private void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static void main(String[] args) {
        Kth_Largest_Element_in_an_Array_215 test = new Kth_Largest_Element_in_an_Array_215();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.print(test.findKthLargest(nums, k));
    }

}
