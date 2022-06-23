package com.study.LeetCode501_600;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * @author jianghui
 * @date 2021-02-08 16:45
 */
public class LeetCode513 {
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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            //当前层的所有结点
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
                //第一个结点
                if (i == 0){
                    ans = curNode.val;
                }
            }
        }
        return ans;
    }

    private int ans = 0;
    private int maxHeight = 0;

    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        //深度+1
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        //当前深度大于目前最大深度 也就是记录当前深度（层）的第一个左节点
        if (height > maxHeight) {
            maxHeight = height;
            ans = root.val;
        }
    }
}
