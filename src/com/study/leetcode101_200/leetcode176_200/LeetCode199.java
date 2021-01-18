package com.study.leetcode101_200.leetcode176_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2021-01-18 09:20
 */
public class LeetCode199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int curSize = queue.size();
            for (int i = 1; i <= curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
                if (i == curSize){
                    ans.add(curNode.val);
                }
            }
        }
        return ans;
    }
}
