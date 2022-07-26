package com.study.leetcode301_400.LeetCode351_375;

/**
 * @author jianghui
 * @date 2022/7/25
 */
public class LeetCode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10;
        for (int i = 2; i <= n; i++) {
            int sum = 9;
            int r = 9;
            for (int j = 1; j < i; j++) {
                sum = sum * r;
                r--;
            }
            ans += sum;
        }
        return ans;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            ans += cur;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode357().countNumbersWithUniqueDigits(8));
    }
}
