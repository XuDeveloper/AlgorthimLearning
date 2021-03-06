package com.xu.string;

// 刷过1遍（2019.08.19 ）

public class First_Unique_Character_in_a_String_387 {

    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
