package com.study.leetcode301_400.LeetCode301_325;

/**
 * @author jianghui
 * @date 2021-01-25 12:38
 */
public class LeetCode309 {
    /**
     * 动态规划 + 空间优化
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        //表示dp[i-2][0];
        int dpPre0 = 0;
        for (int price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dpPre0 - price);
            dpPre0 = temp;
        }
        return dp0;
    }
}
