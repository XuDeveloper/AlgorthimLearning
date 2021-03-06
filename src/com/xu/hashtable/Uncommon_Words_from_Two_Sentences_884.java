package com.xu.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uncommon_Words_from_Two_Sentences_884 {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: A.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word: B.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key) == 1) {
                res.add(key);
            }
        }
        return res.toArray(new String[0]);
    }

}
