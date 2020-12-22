package com.study.leetcode1_100.leetcode26_50;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author jianghui
 * @date 2020-09-28  10:57
 **/
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] cell = new int[9][9];
        for (int i = 0;i < 9;i++){
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.'){
                    int n = num - '1';
                    int cellIndex = (i / 3) * 3 + j / 3;
                    if (row[i][n] == 1 || col[j][n] == 1 || cell[cellIndex][n] == 1){
                        return false;
                    }
                    row[i][n] = 1;
                    col[j][n] = 1;
                    cell[cellIndex][n] = 1;
                }
            }
        }
        return true;
    }
}
