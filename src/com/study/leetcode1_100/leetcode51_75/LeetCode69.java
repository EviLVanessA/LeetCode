package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-18 17:59
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        long i = 0;
        while (true) {
            if (i * i > x) {
                return (int) (i - 1);
            } else {
                i++;
            }
        }
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode69().mySqrt(2147395600));
    }
}
