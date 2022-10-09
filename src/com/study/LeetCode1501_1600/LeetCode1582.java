package com.study.LeetCode1501_1600;

/**
 * @author jianghui
 * @date 2022-09-04 12:08
 */
public class LeetCode1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += mat[k][j];
                    }
                    for (int k = 0; k < n; k++) {
                        sum += mat[i][k];
                    }
                    if (sum == 2) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
