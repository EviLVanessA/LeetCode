package com.study.LeetCode1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/30
 */
public class LeetCode1022 {
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

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int ans) {
        if (root == null) {
            return 0;
        }
        ans = ans << 1 + root.val;
        if (root.left == null && root.right == null) {
            return ans;
        }
        return dfs(root.left, ans) + dfs(root.right, ans);
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("1010", 2));
    }
}
