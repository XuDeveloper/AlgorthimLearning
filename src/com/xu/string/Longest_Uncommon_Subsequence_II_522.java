package com.xu.string;

/**
 * http://blog.csdn.net/zsensei/article/details/75227927
 */
public class Longest_Uncommon_Subsequence_II_522 {

    public int findLUSlength(String[] strs) {
        int longest = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) longest = Math.max(longest, strs[i].length());
        }
        return longest;
    }

    //判断 a 是否是 b 的子串
    public boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) return false;
        if (a.equals(b)) return true;

        int position = 0;

        for (int i = 0; i < b.length(); i++) {
            if (position == a.length()) break;
            if (a.charAt(position) == b.charAt(i)) {
                position++;
            }
        }
        return position == a.length();
    }

}
