package com.xu.bfs;

import javafx.util.Pair;

import java.util.*;

public class Word_Ladder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //替换掉题目中List结构，加速查找
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        wordSet.remove(beginWord);
        StringBuilder sb;
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.removeFirst();
            String word = pair.getKey();
            int step = pair.getValue();
            if (word.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < word.length(); i++) {
                sb = new StringBuilder(word);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    String tmp = sb.toString();
                    if (tmp.equals(word)) {
                        continue;
                    }
                    if (tmp.equals(endWord)) {
                        return step + 1;
                    }
                    if (wordSet.contains(tmp)) {
                        if (visited.containsKey(tmp)) {
                            if (!visited.get(tmp)) {
                                queue.add(new Pair<>(tmp, step + 1));
                                wordSet.remove(tmp);
                                visited.put(tmp, true);
                            }
                        } else {
                            queue.add(new Pair<>(tmp, step + 1));
                            wordSet.remove(tmp);
                            visited.put(tmp, true);
                        }
                    }
                }
            }
        }
        return 0;
    }

}
