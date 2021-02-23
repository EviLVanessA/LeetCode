package com.study.LeetCode801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-02-23 15:45
 */
public class LeetCode872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        List<Integer> list1 = new ArrayList<>(ans);
        ans.clear();
        dfs(root2);
        List<Integer> list2 = new ArrayList<>(ans);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    List<Integer> ans = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
    }
}
