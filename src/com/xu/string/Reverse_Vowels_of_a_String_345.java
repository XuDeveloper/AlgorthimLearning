package com.xu.string;

public class Reverse_Vowels_of_a_String_345 {

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        char temp;
        while (start < end) {
            if (checkVowel(ch[start]) && checkVowel(ch[end])) {
                temp = ch[end];
                ch[end] = ch[start];
                ch[start] = temp;
                start++;
                end--;
            } else {
                if (!checkVowel(ch[start])) {
                    start++;
                }
                if (!checkVowel(ch[end])) {
                    end--;
                }
            }
        }
        return new String(ch);
    }

    public boolean checkVowel(char c) {
        if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
                || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
            return true;
        }
        return false;
    }

}
