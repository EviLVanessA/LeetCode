package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * @author jianghui
 * @date 2020-12-29 11:00
 */
public class LeetCode114 {
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
     * 以下为递归调用
     */
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = list.get(i);
            cur = cur.right;
        }
        cur.left = cur.right = null;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 迭代法
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    /**
     * 寻找前驱节点 寻找当前节点的右子树再左子树中的前驱节点 即当前节点左子树的最右侧的叶子结点
     * @param root
     */
    public void flatten3(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null){
                TreeNode next = cur.left;
                TreeNode predecessor = next;
                while (predecessor.right != null){
                    predecessor = predecessor.right;
                }
                predecessor.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

}
