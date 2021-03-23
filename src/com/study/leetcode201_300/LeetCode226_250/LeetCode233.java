package com.study.leetcode201_300.LeetCode226_250;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * @author jianghui
 * @date 2021-03-01 20:56
 */
public class LeetCode233 {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return count;
    }

}
