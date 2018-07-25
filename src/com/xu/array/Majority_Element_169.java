package com.xu.array;

public class Majority_Element_169 {

    public int majorityElement(int[] nums) {
        int c = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c == 0) {
                temp = nums[i];
                c = 1;
            } else {
                if (temp == nums[i]) {
                    c++;
                } else {
                    c--;
                }
            }
        }
        return temp;
    }
}
