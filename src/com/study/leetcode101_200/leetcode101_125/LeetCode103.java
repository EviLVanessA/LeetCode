package com.study.leetcode101_200.leetcode101_125;

import java.util.*;

/**
 * @author jianghui
 * @date 2020-12-28 09:05
 */
public class LeetCode103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()){
            Deque<Integer> levelList = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft){
                    levelList.offerLast(curNode.val);
                }else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            ans.add(new ArrayList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
