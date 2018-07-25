package com.xu.array;

public class Merge_Sorted_Array_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        // B has elements left
        while (n > 0) {
            nums1[index] = nums2[n - 1];
            n--;
            index--;
        }
    }

}
