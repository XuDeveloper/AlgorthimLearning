package com.xu.string;

public class Length_of_Last_Word_58 {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;
        int cnt = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

}
