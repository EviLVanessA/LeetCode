package com.study.competition.competition298;

/**
 * @author jianghui
 * @date 2022-06-19 11:53
 */
public class LeetCode5254 {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] sales = new int[m + 1][n + 1];
        //直接卖
        for (int[] price : prices) {
            sales[price[0]][price[1]] = price[2];
        }
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //直接卖
                dp[i][j] = sales[i][j];
                //水平分
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                //垂直分
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }
}
