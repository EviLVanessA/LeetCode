package com.study.leetcode401_500;

/**
 * @author jianghui
 * @date 2022-05-29 10:48
 */
public class LeetCode441 {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode441().arrangeCoins(1804289383));
    }
}
