package com.study.leetcode301_400.LeetCode301_325;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/16
 */
public class LeetCode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int[] nums = new int[primes.length];
        int[] results = new int[primes.length];
        Arrays.fill(results, 1);
        for (int i = 1; i <= n; i++) {
            int minNum = Arrays.stream(results).min().getAsInt();
            dp[i] = minNum;
            for (int j = 0; j < primes.length; j++) {
                if (results[j] == minNum) {
                    nums[j]++;
                    results[j] = dp[nums[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }
}
