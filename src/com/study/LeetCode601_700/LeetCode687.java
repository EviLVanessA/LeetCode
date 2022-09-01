package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2021-02-21 16:34
 */
public class LeetCode687 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = 0;
        int rightPath = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            leftPath += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightPath += right + 1;
        }
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
