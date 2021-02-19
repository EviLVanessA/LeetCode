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
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int maxI = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxI]);
        root.left = construct(nums, l, maxI);
        root.right = construct(nums, maxI + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int maxI = l;
        for (int i = l; i < r; i++) {
            if (nums[maxI] < nums[i]) {
                maxI = i;
            }
        }
        return maxI;
    }

}
