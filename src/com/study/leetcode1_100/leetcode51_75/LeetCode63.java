package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-16 15:46
 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (!flag &&obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
            if (obstacleGrid[i][0] == 1){
                flag = true;
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            if (!flag &&obstacleGrid[0][i] != 1){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
            if (obstacleGrid[0][i] == 1){
                flag = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
