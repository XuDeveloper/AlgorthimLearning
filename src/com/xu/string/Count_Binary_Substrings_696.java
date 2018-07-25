package com.xu.string;

/**
 * https://www.polarxiong.com/archives/LeetCode-696-count-binary-substrings.html
 */
public class Count_Binary_Substrings_696 {

    public int countBinarySubstrings(String s) {
        int result = 0;
        int prevLength = 0;
        int curLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLength++;
            } else {
                prevLength = curLength;
                curLength = 1;
            }
            if (prevLength >= curLength) {
                result++;
            }
        }
        return result;
    }

}
