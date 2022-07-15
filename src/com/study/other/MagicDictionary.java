package com.study.other;

/**
 * @author jianghui
 * @date 2022-07-11 07:46
 */
public class MagicDictionary {


    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insertNode(root, s);
        }
    }

    public boolean search(String searchWord) {
        return search(root, searchWord, 0, false);
    }

    class TrieNode {
        /**
         * 字典树的子节点
         */
        private TrieNode[] child;
        /**
         * 是否是单词
         */
        private boolean isWord;

        public TrieNode() {
            //初始时每个都是26个小写字母
            child = new TrieNode[26];
            isWord = false;
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
        cur.isWord = true;
    }

    public boolean search(TrieNode node, String word, int index, boolean diff) {
        //字符全部遍历完
        if (index == word.length()) {
            return diff && node.isWord;
        }
        int i = word.charAt(index) - 'a';
        //字典树是否存在该字符
        if (node.child[i] != null) {
            if (search(node.child[i], word, index + 1, diff)) {
                return true;
            }
        }
        //不存在 判断是否有进行替换
        // diff为false表示没有替换过单词，可以进行替换
        if (!diff) {
            //枚举当前结点的所有子结点进行遍历
            //匹配剩余字符
            for (int j = 0; j < 26; j++) {
                if (j != i && node.child[j] != null) {
                    if (search(node.child[j], word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
