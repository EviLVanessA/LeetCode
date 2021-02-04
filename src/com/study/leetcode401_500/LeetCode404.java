package com.study.leetcode401_500;

/**
 * @author jianghui
 * @date 2021-02-04 14:27
 */
public class LeetCode404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum = sum + root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
    }
}
