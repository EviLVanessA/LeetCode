package com.study.other;

/**
 * @author jianghui
 * @date 2022/5/6
 */
public class NumMatrix2 {
    private int[][] preSum;

    public NumMatrix2(int[][] matrix) {
        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            preSum = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //蓝+红-蓝红交叉+当前元素
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}
