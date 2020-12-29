package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * @author jianghui
 * @date 2020-12-29 09:49
 */
public class LeetCode111 {
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
     * 深度优先遍历 DFS
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }


    public class Node {
        TreeNode treeNode;
        int depth;

        public Node(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.treeNode.left == null && node.treeNode.right == null) {
                return node.depth;
            }
            if (node.treeNode.left != null) {
                queue.offer(new Node(node.treeNode.left, node.depth + 1));
            }
            if (node.treeNode.right != null) {
                queue.offer(new Node(node.treeNode.right, node.depth + 1));
            }
        }
        return 0;
    }
}
