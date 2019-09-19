package com.xu.string;

// 刷过1遍（2019.09.18 ）

public class Detect_Capital_520 {

    public boolean detectCapitalUse(String word) {
        int numCap = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a') {
                numCap++;
            }
        }
        if (numCap == 0 || numCap == word.length()) {
            return true;
        }
        if (numCap == 1) {
            return word.charAt(0) < 'a';
        }
        return false;
    }

}
