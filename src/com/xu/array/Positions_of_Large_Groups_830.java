package com.xu.array;

import java.util.ArrayList;
import java.util.List;

public class Positions_of_Large_Groups_830 {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int count = 1;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i - count + 1);
                    temp.add(i);
                    res.add(temp);
                }
                count = 1;
            }
            // 特殊："aaa"
            if (i == S.length() - 2 && count >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i - count + 2);
                temp.add(i + 1);
                res.add(temp);
                count = 1;
            }
        }
        return res;
    }

}
