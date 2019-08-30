package com.xu.string;

// 愚人节！！！（https://www.polarxiong.com/archives/LeetCode-521-longest-uncommon-subsequence-i.html）

public class Longest_Uncommon_Subsequence_I_521 {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
