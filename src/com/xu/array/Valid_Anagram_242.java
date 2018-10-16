package com.xu.array;

import java.util.HashMap;

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

//    public boolean isAnagram(String s, String t) {
//        int[] letters = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            letters[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            letters[t.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < letters.length; i++) {
//            if (letters[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

}
