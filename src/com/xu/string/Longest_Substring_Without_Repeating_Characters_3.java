package com.xu.string;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                int index = map.get(s.charAt(i));
                for (int j = start; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i), i);
                start = index + 1;
                len = i - index;
            }
        }
        return maxLen;
    }

}
