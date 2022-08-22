package com.study.LeetCode1301_1400;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2022/8/17
 */
public class LeetCode1302 {

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

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            int curSum = 0;
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                curSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            sum = curSum;
        }
        return sum;
    }
}
