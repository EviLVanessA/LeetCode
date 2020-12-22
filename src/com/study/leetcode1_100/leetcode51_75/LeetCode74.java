package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-21 11:06
 */
public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }
        int i = 0, j = col - 1, k = 0;
        while (i < j && k < row) {
            if (target > matrix[k][j]) {
                k++;
            } else {
                if (target == matrix[k][i]){
                    return true;
                }else {
                    i++;
                }
            }
        }
        return false;
    }
}
