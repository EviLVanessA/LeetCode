package com.study.competition.competition305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-08-07 11:01
 */
public class LeetCode6138 {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            for (int j = Math.max(cur - k, 0); j <= Math.min(cur + k, 25); j++) {
                dp[cur] = Math.max(dp[cur], dp[j]);
            }
            dp[cur]++;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
    }

}
