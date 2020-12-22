package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-11 17:29
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxRight) {
                maxRight = Math.max(maxRight, i + nums[i]);
                if (maxRight >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
