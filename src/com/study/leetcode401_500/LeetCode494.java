package com.study.leetcode401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * @author jianghui
 * @date 2021-01-25 16:55
 */
public class LeetCode494 {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return S == 0 ? 1 : 0;
        }
        backTrack(nums, 0, S);
        return ans;
    }

    /**
     * 回溯法
     *
     * @param nums
     * @param index
     * @param rest
     */
    private void backTrack(int[] nums, int index, int rest) {
        if (index == nums.length) {
            if (rest == 0) {
                ans++;
            }
            return;
        }
        rest += nums[index];
        backTrack(nums, index + 1, rest);
        rest -= nums[index];

        rest -= nums[index];
        backTrack(nums, index + 1, rest);
    }

    /**
     * 记忆化搜索
     *
     * @param nums
     * @param target
     * @return
     */
    int findTargetSumWays2(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, target);
    }

    Map<String, Integer> memory = new HashMap<>();

    private int dp(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        String key = index + "," + target;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        int ans = dp(nums, index + 1, target - nums[index]) + dp(nums, index + 1, target + nums[index]);
        memory.put(key, ans);
        return ans;
    }

    /**
     * 设A为选+ B为选-
     * 则 sum(A) - sum(B) = target
     * ∴ sum(A) = sum(B) + target
     * ∴ 2 * sum(A) = sum(A) + sum(B) + target
     * ∴ sum(A) = (sum(nums) + target) / 2
     * 转化为 子集划分问题 选择多少个数的和为sum(A)
     * @param nums
     * @param target
     * @return
     */
    int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        return subSets(nums, (sum + target) / 2);
    }

    /**
     * 动态规划 将该问题变为子集划分问题（0-1背包问题）
     *
     * @param nums
     * @param sum
     * @return
     */
    private int subSets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                //当背包容量大于物品重量
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 动态规划 + 空间优化
     * @param nums
     * @param sum
     * @return
     */
    private int subSets2(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                //当背包容量大于物品重量
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sum];
    }
}
