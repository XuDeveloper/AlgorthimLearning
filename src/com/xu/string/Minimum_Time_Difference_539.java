package com.xu.string;

import java.util.Arrays;
import java.util.List;

public class Minimum_Time_Difference_539 {

    public int findMinDifference(List<String> timePoints) {
        int[] minuteArr = new int[timePoints.size()];
        for (int i = 0; i < minuteArr.length; i++) {
            minuteArr[i] = transfer(timePoints.get(i));
        }
        Arrays.sort(minuteArr);

        int res = 24*60 - minuteArr[minuteArr.length-1] + minuteArr[0];
        for (int i = 0; i < minuteArr.length-1; i++) {
            if (minuteArr[i+1] - minuteArr[i] < res) res = minuteArr[i+1] - minuteArr[i];
        }
        return res;
    }

    public int transfer(String time) {
        String[] arr = time.split(":");
        int a = Integer.parseInt(arr[0]) * 60;
        int b = Integer.parseInt(arr[1]);
        return a + b;
    }

}
