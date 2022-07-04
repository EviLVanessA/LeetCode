package com.study.competition.competition300;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-07-03 11:52
 */
public class LeetCode6110 {
    static final int MOD = (int) 1e9 + 7;
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    int[][] grid, f;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = (ans + dfs(i, j)) % MOD;
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        if (f[i][j] != -1) {
            return f[i][j];
        }
        int res = 1;
        for (int[] d : dirs) {
            int newX = i + d[0], newY = j + d[1];
            if (0 <= newX && newX < m && 0 <= newY && newY < n && grid[newX][newY] > grid[i][j]) {
                res = (res + (dfs(newX, newY))) % MOD;
            }
        }
        return f[i][j] = res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6110().countPaths(new int[][]{{1, 1}, {3, 4}}));
    }
}
