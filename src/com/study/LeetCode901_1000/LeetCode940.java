package com.study.LeetCode901_1000;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/10/13
 */
public class LeetCode940 {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int ans = 0;
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            char aChar = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] += dp[last[j]];
                    dp[i] = dp[i] % mod;
                }
            }
            dp[i]++;
            dp[i] = dp[i] % mod;
            last[aChar - 'a'] = i;
        }
        for (int j = 0; j < 26; j++) {
            if (last[j] != -1) {
                ans += dp[last[j]];
                ans = ans % mod;
            }
        }
        return ans;
    }

    public int distinctSubseqII2(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int newCount = curAns;
            preCount[chs[i] - 'a'] = newCount;
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
        }
        return curAns - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode940().distinctSubseqII2("aba"));
    }
}
