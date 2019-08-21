package com.xu.string;

public class Custom_Sort_String_791 {

    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c: T.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char s: S.toCharArray()) {
            while (count[s - 'a'] > 0) {
                sb.append(s);
                count[s - 'a']--;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while(count[c - 'a'] > 0){
                sb.append(c);
                count[c - 'a']--;
            }
        }
        return sb.toString();
    }

}
