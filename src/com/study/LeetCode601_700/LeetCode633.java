package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/6/2
 */
public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int left = 1, right = c;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) left * left + (long) right * right == c) {
                return true;
            } else if ((long) left * left + (long) right * right > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
