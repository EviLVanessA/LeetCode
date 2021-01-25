package com.study.leetcode101_200.leetcode101_125;

/**
 * @author jianghui
 * @date 2020-12-30 11:04
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                min = prices[i];
                total = total + max;
                max = 0;
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        total = total + max;
        return total;
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划优化空间复杂度
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, temp - price);
        }
        return dp0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
