package com.study.LeetCode1101_1200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2022-07-30 21:45
 */
public class LeetCode1161 {

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

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = Integer.MIN_VALUE;
        int target = 1;
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int curAns = 0;
            int curSize = queue.size();
            curLevel++;
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                curAns += curNode.val;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            if (curAns > ans) {
                target = curLevel;
                ans = curAns;
            }
        }
        return target;
    }
}
