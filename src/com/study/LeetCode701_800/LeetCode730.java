package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-06-09 22:11
 */
public class LeetCode730 {
    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        //一个单字符是一个回文子序列
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //从长度为2的子串开始计算
        for (int len = 2; len <= n; len++) {
            //挨个计算长度为len的子串的回文子序列个数
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                //情况(1) 相等
                if (s.charAt(i) == s.charAt(j)) {
                    int left = i + 1;
                    int right = j - 1;
                    //找到第一个和s[i]相同的字符
                    while (left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    //找到第一个和s[j]相同的字符
                    while (left <= right && s.charAt(right) != s.charAt(j)) {
                        right--;
                    }
                    if (left > right) {
                        //情况① 没有重复字符
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (left == right) {
                        //情况② 出现一个重复字符
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        //情况③ 有两个及两个以上
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {
                    //情况(2) 不相等
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                //处理超范围结果
                dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % mod : dp[i][j] + mod;
            }
        }
        return dp[0][n - 1];
    }
}
