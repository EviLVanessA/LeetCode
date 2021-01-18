package com.study.leetcode201_300.LeetCode226_250;

/**
 * 翻转二叉树
 * 相关试题100 101 222 110
 * @author jianghui
 * @date 2020-09-17  12:50
 **/
public class LeetCode226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
