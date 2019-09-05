package com.xu.string;

public class Reverse_Only_Letters_917 {

    public String reverseOnlyLetters(String S) {
        int length = S.length();
        int i = 0;
        int j = length - 1;
        char[] c = S.toCharArray();
        while (i < j) {
            while (i < j && !Character.isAlphabetic(c[i])) {
                i++;
            }
            while (i < j && !Character.isAlphabetic(c[j])) {
                j--;
            }
            if (i < j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }

}
