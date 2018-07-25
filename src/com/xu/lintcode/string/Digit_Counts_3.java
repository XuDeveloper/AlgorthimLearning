package com.xu.lintcode.string;

public class Digit_Counts_3 {

    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int count = 0;
        char kChar = (char) (k + '0');
        for (int i = k; i <= n; i++) {
            char[] iChars = Integer.toString(i).toCharArray();
            for (char iChar: iChars) {
                if (iChar == kChar) {
                    count++;
                }
            }
        }
        return count;
    }

}
