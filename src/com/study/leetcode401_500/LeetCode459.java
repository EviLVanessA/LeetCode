package com.study.leetcode401_500;

/**
 * @author jianghui
 * @date 2021-01-19 10:45
 */
public class LeetCode459 {
    /**
     * 暴力枚举
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符串匹配
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

}
