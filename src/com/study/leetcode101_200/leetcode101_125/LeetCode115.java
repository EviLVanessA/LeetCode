package com.study.leetcode101_200.leetcode101_125;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * @author jianghui
 * @date 2020-12-29 12:45
 */
public class LeetCode115 {
    /**
     * 动态规划
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        //进行dp边界的初始化
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    //如果当前两个字符相等，则当前dp等于 两个字符串同时去掉该字符 和 s中去掉该字符时的dp
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    //如果当前两个字符不相等，则当前dp为s字符串去掉该字符的dp 即当前s中有没有该字符都不受影响
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
