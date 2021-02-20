package com.study.LeetCode601_700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-02-20 10:22
 */
public class LeetCode655 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] ans = new String[height][(1 << height) - 1];
        for (String[] arr : ans) {
            Arrays.fill(arr, "");
        }
        List<List<String>> res = new ArrayList<>();
        fill(ans, root, 0, 0, ans[0].length);
        for (String[] arr : ans) {
            res.add(Arrays.asList(arr));
        }
        return res;
    }

    private void fill(String[][] ans, TreeNode root, int i, int l, int r) {
        if (root == null) {
            return;
        }
        ans[i][(l + r) / 2] = "" + root.val;
        fill(ans, root.left, i + 1, l, (l + r) / 2);
        fill(ans, root.right, i + 1, (l + r + 1) / 2, r);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
