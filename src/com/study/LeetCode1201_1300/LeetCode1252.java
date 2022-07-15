package com.study.LeetCode1201_1300;

/**
 * @author jianghui
 * @date 2022-07-12 07:55
 */
public class LeetCode1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        for (int[] index : indices) {
            //给index[0]行+1
            for (int i = 0; i < n; i++) {
                grid[index[0]][i]++;
            }
            //给index[1]列+1
            for (int i = 0; i < m; i++) {
                grid[i][index[1]]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % 2 != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int oddCells2(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        //统计个数
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        //找叠加次数为奇数的行
        int rowOdd = 0;
        for (int i = 0; i < m; i++) {
            if ((row[i] & 1) == 0) {
                rowOdd++;
            }
        }
        //找叠加次数为奇数的列
        int colOdd = 0;
        for (int i = 0; i < n; i++) {
            if ((col[i] & 1) == 0) {
                colOdd++;
            }
        }
        return rowOdd * n + colOdd * m - 2 * rowOdd * colOdd;
    }
}
