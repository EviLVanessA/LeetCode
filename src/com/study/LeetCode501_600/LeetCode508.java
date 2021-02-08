package com.study.LeetCode501_600;

import java.util.*;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * @author jianghui
 * @date 2021-02-08 16:01
 */
public class LeetCode508 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static Map<Integer, Integer> ans = new HashMap<>();

    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        dfs(root);
        int maxInt = 0;

        for (int i : ans.keySet()){
            maxInt = Math.max(ans.get(i),maxInt);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : ans.keySet()){
            if (ans.get(i) == maxInt){
                res.add(i);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = right + left + root.val;
        ans.put(temp, ans.getOrDefault(temp, 0) + 1);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(-5);
        int[] frequentTreeSum = findFrequentTreeSum(root);
        for (int i :frequentTreeSum){
            System.out.println(i);
        }
    }
}
