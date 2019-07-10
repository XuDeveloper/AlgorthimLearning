package com.xu.string;

import java.util.HashSet;
import java.util.Set;

public class Unique_Morse_Code_Words_804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}
