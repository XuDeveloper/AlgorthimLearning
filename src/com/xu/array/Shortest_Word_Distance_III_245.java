package com.xu.array;

public class Shortest_Word_Distance_III_245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0)
            return -1;

        if (word1 == null || word2 == null)
            return -1;

        boolean isSame = false;

        if (word1.equals(word2))
            isSame = true;

        int shortest = Integer.MAX_VALUE;

        int prev = -1;
        int i1 = -1;
        int i2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (isSame) {
                if (words[i].equals(word1)) {
                    if (prev != -1) {
                        shortest = Math.min(shortest, i - prev);
                    }
                    prev = i;
                }
            } else {
                if (word1.equals(words[i])) {
                    i1 = i;
                    if (i2 != -1) {
                        shortest = Math.min(shortest, i - i2);
                    }
                } else if (word2.equals(words[i])) {
                    i2 = i;
                    if (i1 != -1) {
                        shortest = Math.min(shortest, i - i1);
                    }
                }
            }
        }

        return shortest;
    }

}
