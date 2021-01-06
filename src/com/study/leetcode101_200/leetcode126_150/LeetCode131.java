package com.study.leetcode101_200.leetcode126_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-01-04 17:28
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        //进行预处理
        //dp[i][j]表示s[i][j]是否为回文串
        boolean[][] dp = new boolean[len][len];
        //当s[i]==s[j]时，dp[i][j] = dp[i+1][j-1];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, ans);
        return ans;
    }

    /**
     * 回溯
     * @param s
     * @param start
     * @param len
     * @param dp
     * @param path
     * @param ans
     */
    private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> ans) {
        if (start == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, ans);
            path.removeLast();
        }
    }
}
