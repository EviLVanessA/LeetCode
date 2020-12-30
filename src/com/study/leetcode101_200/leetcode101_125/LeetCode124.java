package com.study.leetcode101_200.leetcode101_125;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 * @author jianghui
 * @date 2020-12-30 17:09
 */
public class LeetCode124 {
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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        //只有在贡献值大于0时才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        //以当前节点为根的左右子树的最大贡献值
        int price = node.val + leftGain + rightGain;
        //更新答案
        maxSum = Math.max(price, maxSum);
        //返回该节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
