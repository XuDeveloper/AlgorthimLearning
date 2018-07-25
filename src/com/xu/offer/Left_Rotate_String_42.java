package com.xu.offer;

public class Left_Rotate_String_42 {

    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) return "";
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String reverse(char[] str, int l, int r) {
        if (l > r) {
            return "";
        }
        char tmp;
        while (l < r) {
            tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(str);
    }
}
