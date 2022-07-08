package com.study.leetcode301_400.LeetCode326_350;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/7/8
 */
public class LeetCode329 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int max = 1;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, dp, i, j);
            }
        }
        return max;
    }

    private void dfs(int[][] matrix, int[][] dp, int x, int y) {
        if (dp[x][y] > 0) {
            return;
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < matrix.length
                    && newY >= 0 && newY < matrix[0].length
                    && matrix[newX][newY] < matrix[x][y]) {
                dfs(matrix, dp, newX, newY);
                dp[x][y] = Math.max(dp[x][y], dp[newX][newY] + 1);
                max = Math.max(max, dp[x][y]);
            }
        }
    }
}
