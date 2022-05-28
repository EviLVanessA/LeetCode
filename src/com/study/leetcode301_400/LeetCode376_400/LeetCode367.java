package com.study.leetcode301_400.LeetCode376_400;

/**
 * @author jianghui
 * @date 2022-05-26 22:36
 */
public class LeetCode367 {
    public static boolean isPerfectSquare(int num) {
        long left = 0, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            System.out.println(mid);
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left * left == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
