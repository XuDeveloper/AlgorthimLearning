package com.xu.hashtable;

// https://blog.csdn.net/fuxuemingzhu/article/details/54236594

public class Longest_Palindrome_409 {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // A的ASCII为41，z的ASCII为122
        int[] chars = new int[58];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'A']++;
        }
        boolean isOdd = false;
        int res = 0;
        for (int aChar : chars) {
            if (aChar % 2 == 1) {
                if (!isOdd) {
                    isOdd = true;
                    res += aChar;
                } else {
                    res += aChar - 1;
                }
            } else {
                res += aChar;
            }
        }
        return res;
    }

}
