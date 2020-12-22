package com.study.leetcode1_100.leetcode26_50;

/**
 * @author jianghui
 * @date 2020-12-11 13:41
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再左右互换
        int i = 0, j = n - 1, k = 0;
        while (k < n) {
            if (i < j) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                j--;
            } else {
                k++;
                i = 0;
                j = n - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        new LeetCode48().rotate(num);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }
}
