package com.xu.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Implement_Magic_Dictionary_676 {

    class MagicDictionary {

        private HashMap<Integer, List<String>> map;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String word: dict) {
                int key = word.length();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(word);
                map.put(key, list);
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            if (!map.containsKey(word.length())) {
                return false;
            } else {
                for (String temp: map.get(word.length())) {
                    int diff = 0, i = 0;
                    for (i = 0; i < temp.length(); i++) {
                        if (word.charAt(i) != temp.charAt(i)) {
                            diff++;
                            if (diff > 1) {
                                break;
                            }
                        }
                    }
                    if (i == word.length() && diff == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
