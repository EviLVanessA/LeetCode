package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-11 16:35
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
