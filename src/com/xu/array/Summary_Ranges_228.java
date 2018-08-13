package com.xu.array;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (i < nums.length - 1 && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }
            if (temp != nums[i]) {
                result.add(temp + "->" + nums[i]);
            } else {
                result.add(temp + "");
            }
        }
        return result;
    }

}
