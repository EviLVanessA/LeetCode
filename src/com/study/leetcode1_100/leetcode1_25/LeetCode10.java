package com.study.leetcode1_100.leetcode1_25;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * @author jianghui
 * @date 2020-09-24  14:42
 **/
public class LeetCode10 {
    /**
     * 采用动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray(), ptr = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= ptr.length; j++) {
                if(ptr[j - 1] != '*') {
                    if(i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }else { //ptr[j - 1] == '*'
                    if(j > 1) {
                        //不管*
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if(i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.')) {
                        //管*
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[str.length][ptr.length];
    }
}
