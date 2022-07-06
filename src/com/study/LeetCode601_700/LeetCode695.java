package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/7/5
 */
public class LeetCode695 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    ans = Math.max(ans, dfs(grid, i, j, visited));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y, int[][] visited) {
        int curCount = 1;
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = dirs[i][0] + x;
            int newY = dirs[i][1] + y;
            if (newX >= 0 && newX < grid.length
                    && newY >= 0 && newY < grid[0].length
                    && visited[newX][newY] == 0 && grid[newX][newY] == 1) {
                curCount += dfs(grid, newX, newY, visited);
            }
        }
        return curCount;
    }

}
