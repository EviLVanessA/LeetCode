package com.study.competition.competition297;

/**
 * @author jianghui
 * @date 2022-06-12 11:35
 */
public class LeetCode5270 {
    int ans = Integer.MAX_VALUE;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        System.arraycopy(grid[0], 0, dp[0], 0, col);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            ans = Math.min(ans, dp[row - 1][i]);
        }
        return ans;
    }

    private void dfs(int index, int[][] grid, int[][] moveCost, int curCost, int lastIndex) {
        if (index == grid.length - 1) {
            ans = Math.min(ans, curCost + grid[index][lastIndex]);
            return;
        }
        for (int i = 0; i < grid[index].length; i++) {
            curCost += (grid[index][i] + moveCost[grid[index][i]][i]);
            dfs(index + 1, grid, moveCost, curCost, i);
            curCost -= (grid[index][i] + moveCost[grid[index][i]][i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5270().minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }
}
