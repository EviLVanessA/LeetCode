package com.study.leetcode101_200.leetcode101_125;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author jianghui
 * @date 2020-12-29 10:21
 */
public class LeetCode113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ans;
    }

    /**
     * 深度优先遍历DFS
     *
     * @param root
     * @param sum
     * @return
     */

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }

    /**
     * 记录每个节点的父节点的映射
     */
    Map<TreeNode, TreeNode> map = new HashMap<>();
//    List<List<Integer>> ans = new ArrayList<>();
    private void getPath(TreeNode node) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            temp.add(0,node.val);
            node = map.get(node);
        }
        ans.add(new ArrayList<>(temp));
    }

    /**
     * BFS 广度优先遍历
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if (root == null){
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> queueSum = new ArrayDeque<>();
        nodeQueue.offer(root);
        queueSum.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null){
                if (rec == sum){
                    getPath(node);
                }
            }else {
                if (node.left != null){
                    map.put(node.left,node);
                    nodeQueue.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null){
                    map.put(node.right,node);
                    nodeQueue.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ans;
    }
}
