package com.study.other;

/**
 * @author jianghui
 * @date 2021-01-18 16:26
 */
public class WordDictionary {
    class Node {
        private Node[] next;
        private boolean isWord;

        public Node() {
            next = new Node[26];
            isWord = false;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curCh = word.charAt(i);
            Node next = curNode.next[curCh - 'a'];
            if (next == null) {
                curNode.next[curCh - 'a'] = new Node();
            }
            curNode = curNode.next[curCh - 'a'];
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, Node node, int start) {
        if (start == word.length()) {
            return node.isWord;
        }
        char curCh = word.charAt(start);
        if (curCh == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && match(word, node.next[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next[curCh - 'a'] == null) {
                return false;
            }
            return match(word, node.next[curCh - 'a'], start + 1);
        }
    }
}
