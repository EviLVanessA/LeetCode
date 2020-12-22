package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-14 10:45
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[n][n];
        int r = 0, c = 0;
        boolean[][] visit = new boolean[n][n];
        int dir = 0;
        for (int i = 1; i <= n*n; i++) {
            ans[r][c] = i;
            visit[r][c] = true;
            int newRow = direction[dir][0] + r;
            int newCol = direction[dir][1] + c;
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || visit[newRow][newCol]) {
                dir = (dir + 1) % 4;
            }
            r = r + direction[dir][0];
            c = c + direction[dir][1];
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
