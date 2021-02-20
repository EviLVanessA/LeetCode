package com.study.LeetCode601_700;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2021-02-20 10:52
 */
public class LeetCode662 {
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

    class AnnotatedNode {
        TreeNode node;
        int depth;
        int pos;

        public AnnotatedNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new ArrayDeque<>();
        queue.offer(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode node = queue.poll();
            if (node.node != null) {
                queue.offer(new AnnotatedNode(node.node.left, node.depth + 1, node.pos * 2));
                queue.offer(new AnnotatedNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
                if (curDepth != node.depth) {
                    curDepth = node.depth;
                    left = node.pos;
                }
                ans = Math.max(ans, node.pos - left + 1);
            }
        }
        return ans;
    }
}
