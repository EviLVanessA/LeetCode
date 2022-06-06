package com.study.demo;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class Demo {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row - 1;
        int pos = row - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = col - 1;
        int ans = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[pos][mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return matrix[pos][ans] == target;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(m, 3));
    }
}
