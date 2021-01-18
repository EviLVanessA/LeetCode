package com.study.leetcode201_300.LeetCode226_250;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树T的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 相关试题98 450 108 230 236(LCA问题 寻找两个结点的最近公共祖先)
 *
 * @author jianghui
 * @date 2020-09-18  9:39
 **/
public class LeetCode235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val){
            return root;
        }

        if (p.val == root.val){
            return p;
        }

        if (q.val == root.val){
            return q;
        }
        if (q.val < root.val && p.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }

    }
}
