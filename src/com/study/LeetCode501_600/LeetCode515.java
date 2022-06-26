package com.study.LeetCode501_600;

import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * @author jianghui
 * @date 2021-02-08 16:54
 */
public class LeetCode515 {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            int curMax = Integer.MIN_VALUE;
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                curMax = Math.max(curMax, node.val);
            }
            ans.add(curMax);
        }
        return ans;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans, int height) {
        if (root == null) {
            return;
        }
        if (height == ans.size()) {
            ans.add(root.val);
        } else {
            ans.set(height, Math.max(root.val, ans.get(height)));
        }
        dfs(root.left, ans, height + 1);
        dfs(root.right, ans, height + 1);
    }
}
