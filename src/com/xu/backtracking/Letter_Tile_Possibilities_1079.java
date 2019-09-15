package com.xu.backtracking;

public class Letter_Tile_Possibilities_1079 {

    public int numTilePossibilities(String tiles) {
        int[] letters = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            letters[tiles.charAt(i) - 'A']++;
        }
        return countPossibilities(letters);
    }

    private int countPossibilities(int[] letters) {
        int count = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                letters[i]--;
                count += 1 + countPossibilities(letters);
                letters[i]++;
            }
        }
        return count;
    }

}
