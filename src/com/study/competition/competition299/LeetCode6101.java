package com.study.competition.competition299;

/**
 * @author jianghui
 * @date 2022-06-26 10:30
 */
public class LeetCode6101 {
    public boolean checkXMatrix(int[][] grid) {
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == j || i + j == col - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
