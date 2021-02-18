package com.study.LeetCode601_700;

import sun.reflect.generics.tree.Tree;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * @author jianghui
 * @date 2021-02-18 10:39
 */
public class LeetCode617 {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        int curVal = 0;
        if (root1 != null) {
            curVal += root1.val;
        }
        if (root2 != null) {
            curVal += root2.val;
        }
        root.val = curVal;

        if (root1 == null || root2 == null) {
            root.left = root1 == null ? root2.left : root1.left;
            root.right = root1 == null ? root2.right : root1.right;
        }else {
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }
        return root;
    }
}
