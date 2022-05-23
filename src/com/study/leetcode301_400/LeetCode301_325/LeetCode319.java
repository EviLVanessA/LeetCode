package com.study.leetcode301_400.LeetCode301_325;

/**
 * @author jianghui
 * @date 2022/5/23
 */
public class LeetCode319 {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        int[] count = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (i % j == 0) {
                    count[i]++;
                }
            }
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (count[i] % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
