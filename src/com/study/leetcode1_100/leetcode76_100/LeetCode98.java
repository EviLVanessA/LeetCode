package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2020-12-24 09:59
 */
public class LeetCode98 {
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

    /**
     * 递归判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root,Integer lower,Integer upper){
        if (root == null){
            return true;
        }
        int val = root.val;
        if (lower != null && lower >= val){
            return false;
        }

        if (upper != null && upper <= val){
            return false;
        }
        //判断左子树
        if (!isBST(root.left,lower,val)){
            return false;
        }
        //判断右子树  下界变为 root.val
        if (!isBST(root.right,val,upper)){
            return false;
        }
        return true;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
