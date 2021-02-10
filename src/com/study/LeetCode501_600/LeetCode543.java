package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2021-02-09 14:20
 */
public class LeetCode543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return max;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int curDiam = leftDepth + rightDepth;
        max = Math.max(curDiam, max);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
