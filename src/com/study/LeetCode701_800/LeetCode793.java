package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-08-27 19:53
 */
public class LeetCode793 {

    public static void main(String[] args) {
        System.out.println(new LeetCode793().calZero(10));
    }

    public int preimageSizeFZF(int k) {
        return (int) (calMinKZero(k + 1) - calMinKZero(k));
    }

    public long calMinKZero(int k) {
        long left = 0L;
        long right = 5L * k;
        long ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calZero(mid) >= k) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int calZero(long n) {
        int ans = 0;
        while (n != 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
}
