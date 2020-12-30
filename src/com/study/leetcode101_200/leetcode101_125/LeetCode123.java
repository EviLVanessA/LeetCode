package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-30 12:46
 */
public class LeetCode123 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义二维数组，5种状态
        int[][] dp = new int[n][5];
        //初始化第一天的状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; ++i) {
            //dp[i][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0] = dp[i - 1][0];
            //处理第一次买入、第一次卖出
            //           之前买入后保持不动(之前已购买)   第一次购买(购买当天的股票)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //           之前卖出后保持不动(之前已卖出)   第一次卖出(以当天的价格卖出)
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //处理第二次买入、第二次卖出
            //           之前第二次买入后保持不动   第一次卖出后的买入(购买当天的股票)
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //           之前第二次卖出后保持不动   第二次买入后的卖出(以当天的价格卖出)
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        //返回最大值
        return Math.max(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), Math.max(dp[n - 1][2], dp[n - 1][3])), dp[n - 1][4]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
}
