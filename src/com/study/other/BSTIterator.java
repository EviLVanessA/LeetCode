package com.study.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-01-14 14:13
 */
public class BSTIterator {
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

    List<Integer> nodeSorted;
    int index;

    public BSTIterator(TreeNode root) {
        this.nodeSorted = new ArrayList<>();
        this.index = -1;
        this.inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nodeSorted.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return nodeSorted.get(++index);
    }

    public boolean hasNext() {
        return this.index + 1 < nodeSorted.size();
    }
}
