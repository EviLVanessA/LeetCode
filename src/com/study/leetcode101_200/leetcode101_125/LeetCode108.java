package com.study.leetcode101_200.leetcode101_125;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author jianghui
 * @date 2020-12-28 14:25
 */
public class LeetCode108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //总选择中间位置左边的数字为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid - 1);
        root.right = createBST(nums, mid + 1, right);
        return root;
    }
}
