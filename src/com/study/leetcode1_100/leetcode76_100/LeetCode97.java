package com.study.leetcode1_100.leetcode76_100;

/**
 * 动态规划+滚动数组优化空间复杂度
 *
 * @author jianghui
 * @date 2020-12-23 17:05
 */
public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                //如果s1的第i个元素和s3的第i + j个元素相等，那么s1前i个元素和 s2的前j个元素是否能交错组成
                //s3前i + j个元素取决于s1的前i - 1个元素和s2的前j个元素是否能交错组成s3的前i + j - 1个元素
                //∴ f(i, j)取决于f(i - 1, j)
                if (i > 0) {
                    //      👇这个f[j]是上一次的 相当于f[i-1][j] 在没有进行空间复杂度优化之前
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                //如果s2的第j个元素和s3的第i + j个元素相等，那么s1前i个元素和 s2的前j个元素是否能交错组成
                //s3前i + j个元素取决于s1的前i个元素和s2的前j-1个元素是否能交错组成s3的前i + j - 1个元素
                //∴ f(i, j)取决于f(i, j-1)
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[m];
    }
}
