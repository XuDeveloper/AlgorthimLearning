package com.xu.string;

public class Reverse_Words_in_a_String_151 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals(""))//由于句子中也可能会有很多空格，所以会产生多余的“”
                continue;
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

}
