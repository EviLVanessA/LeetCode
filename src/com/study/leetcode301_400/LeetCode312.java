package com.study.leetcode301_400;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 *
 * @author jianghui
 * @date 2021-01-28 12:13
 */
public class LeetCode312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        //i从上往下
        for (int i = n; i >= 0; i--) {
            //j从左往右
            for (int j = i + 1; j < n + 2; j++) {
                //k表示最后戳破哪个气球
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][k] + dp[k][j] + points[i] * points[j] * points[k], dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
