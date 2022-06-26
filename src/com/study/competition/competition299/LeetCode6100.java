package com.study.competition.competition299;

/**
 * @author jianghui
 * @date 2022-06-26 10:36
 */
public class LeetCode6100 {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        long[][] dp = new long[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][1] = dp[i - 1][0];
        }
        long ans = (dp[n - 1][0] + dp[n - 1][1]) % mod;
        return (int) ((ans * ans) % mod);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6100().countHousePlacements(1000));
    }

}
