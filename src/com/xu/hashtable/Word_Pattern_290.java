package com.xu.hashtable;

import java.util.HashMap;

public class Word_Pattern_290 {

    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String arr[] = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            } else if (map.containsValue(arr[i])) {
                return false;
            }
            map.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }

}
