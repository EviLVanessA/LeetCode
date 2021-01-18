package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-01-18 16:36
 */
public class LeetCode212 {
    class TreeNode {
        //可以使用HashMap 也可以使用数组
        Map<Character, TreeNode> links = new HashMap<>();
        String word = null;

        public TreeNode() {
        }
    }

    char[][] board = null;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();
        //将所有的单词存放在字典树当中
        for (String word : words) {
            TreeNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.links.containsKey(letter)) {
                    node = node.links.get(letter);
                } else {
                    TreeNode newNode = new TreeNode();
                    node.links.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.links.containsKey(board[i][j])) {
                    backTacking(i, j, root);
                }
            }
        }
        return result;
    }

    /**
     * 对当前二维数组进行回溯遍历
     *
     * @param row
     * @param col
     * @param parent
     */
    private void backTacking(int row, int col, TreeNode parent) {
        Character letter = this.board[row][col];
        TreeNode curNode = parent.links.get(letter);
        if (curNode.word != null) {
            this.result.add(curNode.word);
            curNode.word = null;
        }
        this.board[row][col] = '#';
        //上右下左
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) {
                continue;
            }
            if (curNode.links.containsKey(this.board[newRow][newCol])) {
                backTacking(newRow, newCol, curNode);
            }
        }
        this.board[row][col] = letter;
        if (curNode.links.isEmpty()) {
            parent.links.remove(letter);
        }
    }
}
