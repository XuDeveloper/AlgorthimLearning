package com.xu.hashtable;

import java.util.HashSet;
import java.util.List;

public class Replace_Words_648 {

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder res = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for (String word: dict) {
            set.add(word);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                String subStr = word.substring(0, j);
                if (set.contains(subStr)) {
                    word = subStr;
                    break;
                }
            }
            res.append(word).append(" ");
        }
        return res.toString().substring(0, res.length() - 1);
    }

    // 前缀树
    // http://www.voidcn.com/article/p-bbkeepik-bmq.html
    // https://blog.csdn.net/u013309870/article/details/71081393
    public String replaceWords2(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

}
