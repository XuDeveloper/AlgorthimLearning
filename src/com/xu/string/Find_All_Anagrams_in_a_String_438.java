package com.xu.string;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int l = 0, r = -1;
        int[] freq = new int[265];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)]++;
        }
        int count = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] >= 1) {
                r++;
                count++;
                freq[s.charAt(r)]--;
            } else {
                freq[s.charAt(l)]++;
                l++;
                count--;
            }
            if (count == p.length()) {
                result.add(l);
            }
        }
        return result;
    }

}
