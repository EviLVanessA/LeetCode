package com.study.leetcode201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 相关题113 129
 * @author jianghui
 * @date 2020-09-18  9:04
 **/
public class LeetCode257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        //递归的终止条件
        if (root == null){
            return res;
        }
        if (root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }
        //获得左子树的路径
        List<String> left = binaryTreePaths(root.left);
        for (String s : left) {
            res.add(root.val + "->" + s);
        }

        //获得右子树的路径
        List<String> right = binaryTreePaths(root.right);
        for (String s : right){
            res.add(root.val + "->" + s);
        }
        return res;
    }
}
