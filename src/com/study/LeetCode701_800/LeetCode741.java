package com.study.LeetCode701_800;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-07-10 08:28
 */
public class LeetCode741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int k = 1; k < 2 * n - 1; k++) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); x1++) {
                if (grid[x1][k - x1] != -1) {
                    for (int x2 = x1; x2 <= Math.min(k, n - 1); x2++) {
                        if (grid[x2][k - x2] != -1) {
                            //都向右移动
                            int preStatus = dp[x1][x2][k - 1];
                            //都向下移动
                            if (x1 > 0 && x2 > 0) {
                                preStatus = Math.max(preStatus, dp[x1 - 1][x2 - 1][k - 1]);
                            }
                            //A向下移动，B向右移动
                            if (x1 > 0) {
                                preStatus = Math.max(preStatus, dp[x1 - 1][x2][k - 1]);
                            }
                            //A向右移动，B向下移动
                            if (x2 > 0) {
                                preStatus = Math.max(preStatus, dp[x1][x2 - 1][k - 1]);
                            }
                            preStatus += grid[x1][k - x1];
                            //是否是同一个走到同一个位置，是的话只能加一个
                            if (x1 != x2) {
                                preStatus += grid[x2][k - x2];
                            }
                            dp[x1][x2][k] = preStatus;
                        }
                    }
                }
            }
        }
        return Math.max(dp[n - 1][n - 1][2 * n - 2], 0);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode741().cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }
}
