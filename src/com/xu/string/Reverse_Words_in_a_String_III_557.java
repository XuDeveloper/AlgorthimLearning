package com.xu.string;

// 刷过1遍（2019.08.07 ）

public class Reverse_Words_in_a_String_III_557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int start = 0, end;
        int len = s.length();
        while (start < len && str[start] == ' ') {
            start++;
        }
        end = start;
        while (end < len) {
            while (end < len && str[end] != ' ') {
                end++;
            }
            int low = start;
            int high = end - 1;
            while (low < high) {
                char temp = str[low];
                str[low] = str[high];
                str[high] = temp;
                low++;
                high--;
            }
            while (end < len && str[end] == ' ') {
                end++;
            }
            start = end;
        }
        return new String(str);
    }
}
