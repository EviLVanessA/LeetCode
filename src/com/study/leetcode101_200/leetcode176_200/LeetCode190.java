package com.study.leetcode101_200.leetcode176_200;

/**
 * @author jianghui
 * @date 2021-01-15 15:27
 */
public class LeetCode190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans << 1;
            ans = n & 1 | ans;
            n = n >> 1;
        }
        return ans;
    }
}
