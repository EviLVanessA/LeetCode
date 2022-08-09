package com.study.competition.competition305;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-08-07 10:54
 */
public class LeetCode6137 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (dp[i - 1] && nums[i] == nums[i - 1] ||
                    i > 1 && dp[i - 2] && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                            nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                dp[i + 1] = true;
            }
        }
        return dp[n];
    }
}
