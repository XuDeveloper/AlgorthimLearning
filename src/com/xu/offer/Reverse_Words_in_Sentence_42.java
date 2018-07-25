package com.xu.offer;

public class Reverse_Words_in_Sentence_42 {

    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(reverse(words[i].toCharArray(), 0, words[i].length() - 1)).append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return reverse(sb.toString().toCharArray(), 0, sb.length() - 1);
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
