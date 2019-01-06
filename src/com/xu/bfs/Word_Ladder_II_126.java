package com.xu.bfs;

import java.util.*;

public class Word_Ladder_II_126 {

    class WordNode {
        String word;
        int steps;
        WordNode preWord;

        public WordNode(String word, int steps, WordNode preWord) {
            this.word = word;
            this.steps = steps;
            this.preWord = preWord;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<WordNode> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(new WordNode(beginWord, 1, null));
        if (!wordList.contains(endWord)) {
            return result;
        }
        wordSet.add(endWord);
        int minStep = 0;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(wordSet);
        int preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.steps;

            if (word.equals(endWord)) {
                if (minStep == 0) {
                    minStep = top.steps;
                }

                if (top.steps == minStep && minStep != 0) {
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while (top.preWord != null) {
                        t.add(0, top.preWord.word);
                        top = top.preWord;
                    }
                    result.add(t);
                    continue;
                }

            }

            if (preNumSteps < currNumSteps) {
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.steps + 1, top));
                        visited.add(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }
        return result;
    }

}
