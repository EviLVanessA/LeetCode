package com.study.leetcode101_200.leetcode101_125;

/**
 * 寻找二叉树的最长深度
 * 相关问题 111
 * @author jianghui
 * @date 2020-09-17  12:44
 **/
public class LeetCode104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
