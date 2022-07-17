package com.study.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/7/13
 */
public class WordFilter {
    Trie prefixTree;
    Trie suffixTree;

    public WordFilter(String[] words) {
        prefixTree = new Trie();
        suffixTree = new Trie();
        for (int i = 0; i < words.length; i++) {
            prefixTree.insertNode(words[i], i);
            //翻转字符串
            String reverseStr = new StringBuilder(words[i]).reverse().toString();
            suffixTree.insertNode(reverseStr, i);
        }
    }

    public int f(String prefix, String suffix) {
        suffix = new StringBuilder(suffix).reverse().toString();

        List<Integer> prefixList;
        List<Integer> suffixList;

        //获取满足前缀的字符串列表
        prefixList = prefixTree.search(prefix);
        //获取满足后缀的字符串列表
        suffixList = suffixTree.search(suffix);
        int prefixLen = prefixList.size();
        int suffixLen = suffixList.size();
        if (prefixLen == 0 || suffixLen == 0) {
            return -1;
        }
        int i = prefixLen - 1;
        int j = suffixLen - 1;
        while (i >= 0 && j >= 0) {
            int prefixIndex = prefixList.get(i);
            int suffixIndex = suffixList.get(j);
            if (prefixIndex == suffixIndex) {
                return prefixIndex;
            } else if (prefixIndex > suffixIndex) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    class TrieNode {
        List<Integer> index;
        TrieNode[] child;

        public TrieNode() {
            index = new ArrayList<>();
            child = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 向字典树中插入单词和其索引
         *
         * @param word  单词
         * @param index 索引
         */
        public void insertNode(String word, int index) {
            TrieNode cur = root;
            cur.index.add(index);
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (cur.child[aChar - 'a'] == null) {
                    cur.child[aChar - 'a'] = new TrieNode();
                }
                cur = cur.child[aChar - 'a'];
                cur.index.add(index);
            }
        }

        public List<Integer> search(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (cur.child[aChar - 'a'] == null) {
                    return new ArrayList<>();
                }
                cur = cur.child[aChar - 'a'];
            }
            return cur.index;
        }
    }
}
