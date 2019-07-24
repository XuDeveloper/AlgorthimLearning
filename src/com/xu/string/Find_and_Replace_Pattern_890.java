package com.xu.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Find_and_Replace_Pattern_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int[] patternArr = getStrPos(pattern);
        for (String word: words) {
            if (Arrays.equals(getStrPos(word), patternArr)) {
                res.add(word);
            }
        }
        return res;
    }

    private int[] getStrPos(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strArr = str.toCharArray();
        int[] res = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (!map.containsKey(strArr[i])) {
                map.put(strArr[i], i);
            }
            res[i] = map.get(strArr[i]);
        }
        return res;
    }

}
