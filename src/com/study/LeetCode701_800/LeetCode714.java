package com.study.LeetCode701_800;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author jianghui
 * @date 2021-01-25 12:46
 */
public class LeetCode714 {
    /**
     * 动态规划 + 空间优化
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (Integer price : prices) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, temp - price - fee);
        }
        return dp0;
    }
}
