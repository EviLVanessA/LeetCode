package com.study.leetcode201_300.LeetCode276_300;

/**
 * @author jianghui
 * @date 2022/4/27
 */
public class LeetCode289 {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(arr);
    }

    public static void gameOfLife(int[][] board) {
        //位移
        int[] neighbors = {-1, 0, 1};
        //行
        int row = board.length;
        //列
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int curRow = i + neighbors[k];
                        int curCol = j + neighbors[l];
                        if (curRow >= 0 && curRow < row && curCol >= 0 && curCol < col && !(neighbors[k] == 0 && neighbors[l] == 0)) {
                            if (Math.abs(board[curRow][curCol]) == 1) {
                                lives++;
                            }
                        }
                    }
                }
                //为活细胞 变为 死细胞
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j] = -1;
                }
                //为死细胞 变为 活细胞
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
