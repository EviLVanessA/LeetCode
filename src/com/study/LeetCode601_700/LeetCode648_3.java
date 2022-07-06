package com.study.LeetCode601_700;

import java.util.List;

/**
 * @author jianghui
 * @date 2022/7/6
 */
public class LeetCode648_3 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }
        String words[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String temp = trie.shortestPrefix(word);
            sb.append(temp);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    class Trie {
        Trie children[];
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public String shortestPrefix(String word) {
            Trie node = this;
            int i = 0;
            for (; i < word.length(); i++) {
                if (node == null) {
                    return word;
                }
                if (node.isEnd) {
                    break;
                }
                int idx = word.charAt(i) - 'a';
                node = node.children[idx];
            }
            return word.substring(0, i);
        }
    }
}
