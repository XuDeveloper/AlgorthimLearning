package com.xu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Common_Characters_1002 {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String s: A) {
            int[] temp = new int[26];
            for (char t: s.toCharArray()) {
                temp[t - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == Integer.MAX_VALUE) {
                continue;
            }
            while (count[i] > 0) {
                count[i]--;
                res.add("" + (char)('a' + i));
            }
        }
        return res;
    }

}
