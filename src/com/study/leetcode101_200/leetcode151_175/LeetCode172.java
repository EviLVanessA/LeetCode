package com.study.leetcode101_200.leetcode151_175;

/**
 * @author jianghui
 * @date 2021-01-11 08:30
 */
public class LeetCode172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode172().trailingZeroes(5));
    }
}
