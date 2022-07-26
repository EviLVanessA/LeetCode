package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/7/21
 */
public class LeetCode343 {
    public int integerBreak(int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            int cur = n / i;
            int re = n % i;
            if (re == 0) {
                ans = Math.max(ans, (int) Math.pow(cur, i));
            } else {
                ans = Math.max(ans, (int) Math.pow(cur, i - re) * (int) Math.pow(cur + 1, re));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode343().integerBreak(10));
    }
}
