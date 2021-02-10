package com.study.LeetCode501_600;

import java.util.Stack;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * @author jianghui
 * @date 2021-02-09 10:33
 */
public class LeetCode538 {
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
    Stack<TreeNode> ans = new Stack<>();
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        dfs(root);
        int size = ans.size();
        TreeNode preNode = ans.pop();

        for (int i = 1; i < size; i++) {
            TreeNode curNode = ans.pop();
            curNode.val = curNode.val + preNode.val;
            preNode = curNode;
        }
        return root;
    }
    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        ans.push(root);
        dfs(root.right);
    }
}
