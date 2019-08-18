package com.xu.string;

// 刷过1遍（2019.08.14 ）

public class Reverse_String_344 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
