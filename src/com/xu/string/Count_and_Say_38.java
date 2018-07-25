package com.xu.string;

/**
 * 题意：即统计上一个数字的情况
 * 如
 * 2 11
 * 3 21
 *
 * 21表示n = 2时有2个1 所以是21
 */
public class Count_and_Say_38 {

    public String countAndSay(int n) {
        if (n < 0) {
            return "";
        }
        StringBuilder seq = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            seq = getNextSeq(seq);
        }
        return seq.toString();
    }

    private StringBuilder getNextSeq(StringBuilder seq) {
        StringBuilder nextSeq = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < seq.length(); i++) {
            if (i + 1 < seq.length() && seq.charAt(i) == seq.charAt(i + 1)) {
                cnt++;
            } else {
                nextSeq.append(cnt).append(seq.charAt(i));
                cnt = 1;
            }
        }
        return nextSeq;
    }

}
