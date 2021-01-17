package com.study.leetcode101_200.leetcode176_200;

/**
 * @author jianghui
 * @date 2021-01-15 15:49
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int ans = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & bit) != 0){
                ans ++;
            }
            bit <<= 1;
        }
        return ans;
    }
}
