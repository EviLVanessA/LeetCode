package com.study.LeetCode601_700;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022/7/6
 */
public class LeetCode648_2 {
    private static final String NONE = "#";

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            insertNode(root, s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!NONE.equals(prefix)) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }

    class TrieNode {
        private TrieNode[] child;
        private boolean prefix;

        public TrieNode() {
            child = new TrieNode[26];
            prefix = false;
        }
    }


    public void insertNode(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char aChar : chars) {
            TrieNode trieNode;
            if (cur.child[aChar - 'a'] == null) {
                trieNode = new TrieNode();
                cur.child[aChar - 'a'] = trieNode;
            }
            trieNode = cur.child[aChar - 'a'];
            cur = trieNode;
        }
        cur.prefix = true;
    }

    public String findPrefix(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            if (cur.child[aChar - 'a'] != null) {
                cur = cur.child[aChar - 'a'];
                if (cur.prefix) {
                    return word.substring(0, i + 1);
                }
            } else {
                return NONE;
            }
        }
        return NONE;
    }
}
