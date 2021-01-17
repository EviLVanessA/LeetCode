package com.study.leetcode101_200.leetcode176_200;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-01-15 10:30
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);
        //buy[i][j] 表示第i天的第j次购买
        int[][] buy = new int[n][k + 1];
        //sell[i][j] 表示第i天的第j次卖
        int[][] sell = new int[n][k + 1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                //第i天卖出 可以是 前一天卖了今天没动 或者是 前一天买了 今天卖的
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
