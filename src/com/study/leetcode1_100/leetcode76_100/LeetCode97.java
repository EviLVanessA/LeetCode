package com.study.leetcode1_100.leetcode76_100;

/**
 * 动态规划+滚动数组优化空间复杂度
 *
 * @author jianghui
 * @date 2020-12-23 17:05
 */
public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[] f = new boolean[len2 + 1];
        f[0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] || s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[len2];
    }
}
