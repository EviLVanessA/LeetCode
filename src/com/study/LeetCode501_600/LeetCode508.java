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

        for (int i : ans.keySet()) {
            maxInt = Math.max(ans.get(i), maxInt);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : ans.keySet()) {
            if (ans.get(i) == maxInt) {
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
        for (int i : frequentTreeSum) {
            System.out.println(i);
        }
    }


    /**
     * 记录子树元素的最大重复个数
     */
    private int maxCount = 1;

    public int[] findFrequentTreeSum2(TreeNode root) {
        //记录子树元素和，以及出现的频数
        Map<Integer, Integer> countMap = new HashMap<>();
        getSumAndCount(root, countMap);
        List<Integer> list = new ArrayList<>();
        //遍历hashmap
        for (Integer k : countMap.keySet()) {
            if (countMap.get(k) == maxCount) {
                list.add(k);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int getSumAndCount(TreeNode root, Map<Integer, Integer> countMap) {
        if (root == null) {
            return 0;
        }
        //求当前节点的左子树的"子树元素和"
        int leftSum = getSumAndCount(root.left, countMap);
        //求当前节点的右子树的"子树元素和"
        int rightSum = getSumAndCount(root.right, countMap);
        //该节点的子树元素
        int curRootSum = root.val + leftSum + rightSum;
        //如果hashmap中包含这个"子树元素和"的值
        if (countMap.containsKey(curRootSum)) {
            int value = countMap.get(curRootSum) + 1;
            //更新hashmap中的键值对
            countMap.put(curRootSum, value);
            //更新“子树数元素和”的最大重复个数
            maxCount = Math.max(maxCount, value);
        } else {
            //如果不存在，直接存入即可
            countMap.put(curRootSum, 1);
        }
        return curRootSum;
    }
}
