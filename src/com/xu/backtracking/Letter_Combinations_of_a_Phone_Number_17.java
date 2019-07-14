package com.xu.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 刷过1遍（2019.07.14 ）

public class Letter_Combinations_of_a_Phone_Number_17 {

//    public List<String> letterCombinations(String digits) {
//        ArrayList<String> result = new ArrayList<String>();
//
//        if (digits == null || digits.equals("")) {
//            return result;
//        }
//
//        Map<Character, char[]> map = new HashMap<>();
//
//        map.put('0', new char[] {});
//        map.put('1', new char[] {});
//        map.put('2', new char[] { 'a', 'b', 'c' });
//        map.put('3', new char[] { 'd', 'e', 'f' });
//        map.put('4', new char[] { 'g', 'h', 'i' });
//        map.put('5', new char[] { 'j', 'k', 'l' });
//        map.put('6', new char[] { 'm', 'n', 'o' });
//        map.put('7', new char[] { 'p', 'q', 'r', 's' });
//        map.put('8', new char[] { 't', 'u', 'v'});
//        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
//
//        StringBuilder sb = new StringBuilder();
//        helper(map, digits, sb, result);
//        return result;
//    }
//
//    public void helper(Map<Character, char[]> map, String digits, StringBuilder sb, ArrayList<String> result) {
//        if (sb.length() == digits.length()) {
//            result.add(sb.toString());
//            return;
//        }
//        for (char c: map.get(digits.charAt(sb.length()))) {
//            sb.append(c);
//            helper(map, digits, sb, result);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }

    // 递归法

    private List<String> result = new ArrayList<>();

    private String[] letterMap = new String[]{
            " ", // 0
            "",  // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return result;
        }
        findCombination(digits, 0, "");
        return result;
    }

    /**
     * s中保存着此时从letters[0..index-1]翻译得到的一个字符串
     * 寻找digits[index]匹配的字符，获得letters[0..index]的解
     *
     * @param digits
     * @param index
     * @param s
     */
    public void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

}
