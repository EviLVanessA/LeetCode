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
        //构建字典树
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            insertNode(root, s);
        }
        String[] words = sentence.split(" ");
        //在字典树中查找每个单词是否有前缀存在
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!NONE.equals(prefix)) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }

    class TrieNode {
        /**
         * 字典树的子节点
         */
        private TrieNode[] child;
        /**
         * 是否是前缀
         */
        private boolean prefix;

        public TrieNode() {
            //初始时每个都是26个小写字母
            child = new TrieNode[26];
            prefix = false;
        }
    }


    /**
     * 向字典树中插入字符
     *
     * @param root 根节点
     * @param word 单词
     */
    public void insertNode(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char aChar : chars) {
            TrieNode trieNode;
            //当前结点不存在aChar结点
            if (cur.child[aChar - 'a'] == null) {
                trieNode = new TrieNode();
                cur.child[aChar - 'a'] = trieNode;
            }
            //指针下移
            trieNode = cur.child[aChar - 'a'];
            cur = trieNode;
        }
        cur.prefix = true;
    }

    /**
     * 在字典树中查找是否包含前缀
     *
     * @param root 根节点
     * @param word 单词
     * @return
     */
    public String findPrefix(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            //判断是否存在该字符
            if (cur.child[aChar - 'a'] != null) {
                cur = cur.child[aChar - 'a'];
                //判断是否是前缀 是直接返回，一定是最短的
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
