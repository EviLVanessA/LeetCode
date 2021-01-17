package com.study.leetcode101_200.leetcode176_200;

/**
 * @author jianghui
 * @date 2021-01-15 11:11
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
    }
}
