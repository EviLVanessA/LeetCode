package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2021-02-19 17:07
 */
public class LeetCode654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return creatTree(nums, 0, nums.length);
    }

    private TreeNode creatTree(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int max = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = creatTree(nums, l, max);
        root.right = creatTree(nums, max + 1, r);
        return root;
    }

    private int max(int[] nums, int l, int r) {
        int max = l;
        for (int i = l; i < r; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

}
