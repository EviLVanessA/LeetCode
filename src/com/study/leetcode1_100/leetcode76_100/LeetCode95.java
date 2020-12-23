package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-23 15:54
 */
public class LeetCode95 {
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //枚举可行根节点
        for (int i = start; i <= end; i++) {
            //获取所有可行的左子树的集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获取所有右子树的集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //从左右子树的集合中选出一颗右子树拼凑到根节点上
            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    allTrees.add(treeNode);
                }
            }
        }
        return allTrees;
    }
}
