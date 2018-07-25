package com.xu.offer;

import java.util.LinkedHashMap;

public class First_Not_Repeat_Char_35 {

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i = 0;
        for (; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return pos;
    }

}
