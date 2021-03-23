package com.study.LeetCode901_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author jianghui
 * @date 2021-03-03 08:56
 */
public class LeetCode938 {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root,low,high);
        return sum;
    }
    int sum = 0;
    private void inorder(TreeNode root, int low, int high){
        if (root == null){
            return;
        }
        inorder(root.left,low,high);
        if (root.val >= low && root.val <= high){
            sum += root.val;
        }
        if (root.val >= high) {
            return;
        }
        inorder(root.right,low,high);
    }
}
