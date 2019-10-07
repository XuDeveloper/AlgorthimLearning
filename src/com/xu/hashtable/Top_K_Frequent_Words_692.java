package com.xu.hashtable;

import java.util.*;

public class Top_K_Frequent_Words_692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        Comparator<Word> cmp = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int diff = o1.val - o2.val;
                if (diff == 0) {
                    return o2.word.compareTo(o1.word);
                } else {
                    return diff;
                }
            }
        };
        Queue<Word> queue = new PriorityQueue<>(k + 1, cmp);
        for (String str: map.keySet()) {
            queue.offer(new Word(map.get(str), str));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll().word);
        }
        Collections.reverse(res);
        return res;
    }

    class Word {
        int val;
        String word;

        public Word(int val, String word) {
            this.val = val;
            this.word = word;
        }
    }

}
