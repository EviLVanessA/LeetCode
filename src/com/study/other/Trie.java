package com.study.other;

/**
 * @author jianghui
 * @date 2021-01-18 14:48
 */
public class Trie {
    private boolean isString = false;
    private Trie[] next = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie root = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new Trie();
            }
            root = root.next[c - 'a'];
        }
        root.isString = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie root = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return root.isString;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return true;
    }
}
