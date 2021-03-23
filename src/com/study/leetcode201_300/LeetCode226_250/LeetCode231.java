package com.study.leetcode201_300.LeetCode226_250;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * @author jianghui
 * @date 2021-03-01 20:27
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return ((long) n & (-(long) n)) == (long) n;
    }
}
