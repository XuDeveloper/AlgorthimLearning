package com.xu.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 刷过1遍（2019.08.26 ）

public class Group_Anagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] letters = new char[26];
            for (int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - 'a']++;
            }
            String arr = new String(letters);
            if (map.containsKey(arr)) {
                map.get(arr).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(arr, temp);
            }
        }
        result.addAll(map.values());
        return result;
    }

}
