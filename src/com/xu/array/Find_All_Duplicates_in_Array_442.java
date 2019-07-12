package com.xu.array;

import java.util.ArrayList;
import java.util.List;

// 刷过1遍 （2019.07.12 ）

public class Find_All_Duplicates_in_Array_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (nums[Math.abs(temp) - 1] > 0) {
                nums[Math.abs(temp) - 1] *= -1;
            } else {
                result.add(Math.abs(temp));
            }
        }
        return result;
    }
}
