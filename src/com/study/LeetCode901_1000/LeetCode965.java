package com.study.LeetCode901_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class LeetCode965 {
    class TreeNode {
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

    public boolean isUnivalTree(TreeNode root) {
        int target = root.val;
        return bfs(root, target);
    }

    private boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return true;
        }
        if (root.val == target) {
            return dfs(root.left, target) && dfs(root.right, target);
        } else {
            return false;
        }
    }
    private boolean bfs(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.val != target) {
                    return false;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return true;
    }

}
