package com.xu.string;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

//    if (s == null) {
//            return 0;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        int start = 0;
//        int maxLen = 0;
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), i);
//                len++;
//                if (len > maxLen) {
//                    maxLen = len;
//                }
//            } else {
//                int index = map.get(s.charAt(i));
//                for (int j = start; j <= index; j++) {
//                    map.remove(s.charAt(j));
//                }
//                map.put(s.charAt(i), i);
//                start = index + 1;
//                len = i - index;
//            }
//        }
//        return maxLen;

}
