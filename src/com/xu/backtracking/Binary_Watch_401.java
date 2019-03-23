package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Binary_Watch_401 {

    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        //用来表示时间的所有可能的取值
        int timecode[] = new int[10];
        read(timecode, num, 0, 0);
        return res;
    }

    private void read(int[] timecode, int num, int start, int temp) {
        if (temp == num) {
            String result = decodeTime(timecode);
            if(result != null)
                res.add(result);
            return;
        }
        if (start == timecode.length) {
            return;
        }
        timecode[start] = 1;
        read(timecode, num, start + 1, temp + 1);
        timecode[start] = 0;
        read(timecode, num, start + 1, temp);
    }

    private String decodeTime(int[] timecode) {
        int hours = 0;
        int minutes = 0;
        for (int i = 0; i < 4; i++) {
            if (timecode[i] == 1) {
                hours = hours + (int) Math.pow(2, i);
            }
        }
        for (int i = 4; i < timecode.length; i++) {
            if (timecode[i] == 1) {
                minutes = minutes + (int) Math.pow(2, i - 4);
            }
        }
        String min = "" + minutes;
        if (minutes < 10)
            min = "0" + min;
        //判断时间的可行性
        if (hours >= 12 || minutes >= 60)
            return null;
        return hours + ":" + min;
    }

}
