package com.study.other;

/**
 * @author jianghui
 * @date 2022/5/6
 */
public class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        //取行数
        int row = matrix.length;
        if (row > 0) {
            //取列数
            int col = matrix[0].length;
            //新建一个 比之前多一个0列的二位数组
            preSum = new int[row][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 1; j < col + 1; j++) {
                    //存储前缀和 此处由于col+1,所以取原来数组时需要-1
                    preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        //进行每行的累加
        for (int i = row1; i <= row2; i++) {
            sum += preSum[i][col2 + 1] - preSum[i][col1];
        }
        return sum;
    }
}
