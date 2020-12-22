package com.study.leetcode101_200;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 相关题111 404
 * @author jianghui
 * @date 2020-09-18  8:55
 **/
public class LeetCode112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }

        return hasPathSum(root.right, sum - root.val) ||
                hasPathSum(root.left,sum-root.val);
    }
}
