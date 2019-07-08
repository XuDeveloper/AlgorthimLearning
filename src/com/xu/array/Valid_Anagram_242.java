package com.xu.array;

import java.util.HashMap;

// 刷过1遍 （2019.07.08 ）

public class Valid_Anagram_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] temp = new int[128];
        for (char c: sArray) {
            temp[c]++;
        }
        for (char c: tArray) {
            temp[c]--;
            if (temp[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
