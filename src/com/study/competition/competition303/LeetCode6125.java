package com.study.competition.competition303;

/**
 * @author jianghui
 * @date 2022-07-24 10:32
 */
public class LeetCode6125 {
    public int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int p = 0, q = 0;
                while (p < col && q < row) {
                    if (grid[i][p] == grid[q][j]) {
                        p++;
                        q++;
                    } else {
                        break;
                    }
                }
                if (p == row) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
