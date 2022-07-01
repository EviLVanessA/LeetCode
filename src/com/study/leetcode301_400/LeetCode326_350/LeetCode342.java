package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/7/1
 */
public class LeetCode342 {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 4 == 0) {
                n = n / 4;
            } else {
                return false;
            }
        }
        return true;
    }
}
