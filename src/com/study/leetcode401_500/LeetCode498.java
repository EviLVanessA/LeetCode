package com.study.leetcode401_500;

/**
 * @author jianghui
 * @date 2022-06-14 08:04
 */
public class LeetCode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int count = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if ((i & 1) == 0) {
                //奇数 判断起始位置
                int x = Math.min(i, m - 1);
                int y = i - x;
                //从右上到左下移动
                while (y < n && x >= 0) {
                    ans[count++] = mat[x][y];
                    x--;
                    y++;
                }
            } else {
                //偶数 判断起始位置
                int y = Math.min(i, n - 1);
                int x = i - y;
                //从左下到右上 移动
                while (x < m && y >= 0) {
                    ans[count++] = mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return ans;
    }
}
