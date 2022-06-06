package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/6/2
 */
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        int i = 0;
        while (true) {
            int sum = (int) Math.pow(3, i);
            if (sum == n) {
                return true;
            }
            if (sum > n) {
                break;
            }
            i++;
        }
        return false;
    }
}
