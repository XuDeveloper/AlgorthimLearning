package com.xu.offer;

public class Replace_Space_4 {

    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int p1 = str.length() - 1;
        int p2 = str.length() + spaceNum * 2 - 1;
        str.setLength(p2 + 1);
        while (p1 >= 0 && p2 > p1) {
            if (str.charAt(p1) == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, str.charAt(p1));
            }
            p1--;
        }
        return str.toString();
    }
}
