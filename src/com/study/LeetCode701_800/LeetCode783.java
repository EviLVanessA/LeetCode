package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2021-02-22 09:13
 */
public class LeetCode783 {
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

    int ans = Integer.MAX_VALUE;
    int prev = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != -1){
            ans = Math.min(ans,root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
}
