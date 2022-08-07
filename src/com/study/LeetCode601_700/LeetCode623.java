package com.study.LeetCode601_700;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * @author jianghui
 * @date 2021-02-18 10:59
 */
public class LeetCode623 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //插入第一层 直接将root变为左结点
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int curDepth = 1;
        //找到插入的上一层
        while (curDepth < depth - 1) {
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            curDepth++;
        }
        //上一层的每个结点都在队列中，我们依次将他们的子节点的父节点变为插入的结点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //左结点
            node.left = new TreeNode(val, node.left, null);
            //右节点
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }

    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 0) {
            TreeNode node = new TreeNode(val);
            node.right = root;
            return node;
        }
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (depth > 1) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        return root;
    }
}
