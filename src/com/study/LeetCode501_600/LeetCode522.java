package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2022-06-26 18:31
 */
public class LeetCode522 {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        //判断strs[i]是不是strs[j]的子序列 若全都不是则记录答案
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    /**
     * 判断str1是不是str2的子序列
     *
     * @param str1
     * @param str2
     * @return
     */
    private boolean isSubsequence(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        //双指针判断str1是否是str2的子序列
        int p = 0, q = 0;
        while (p < str1.length() && q < str2.length()) {
            if (str1.charAt(p) == str2.charAt(q)) {
                p++;
                q++;
            } else {
                q++;
            }
        }
        return p == str1.length();
    }
}
