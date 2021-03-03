package com.study.LeetCode801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * @author jianghui
 * @date 2021-03-02 17:51
 */
public class LeetCode897 {
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

    List<Integer> ans = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return createTree(0);
    }

    private TreeNode createTree(int i) {
        TreeNode node = null;
        if (i < ans.size()) {
            node = new TreeNode(ans.get(i));
            node.left = null;
            node.right = createTree(i + 1);
        }
        return node;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

}
