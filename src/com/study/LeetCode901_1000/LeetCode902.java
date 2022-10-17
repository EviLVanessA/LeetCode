package com.study.LeetCode901_1000;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/10/17
 */
public class LeetCode902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        return 0;
    }


    public int atMostNGivenDigitSet2(String[] digits, int n) {
        int ans = 0;

        // 对 digits 数组进行预处理
        int[] less_than_d = new int[10];
        int[] d_arr = new int[10];
        for (int i = 0; i < digits.length; i++) {
            Arrays.fill(less_than_d, Integer.parseInt(digits[i]) + 1, 10, i + 1);
            d_arr[Integer.parseInt(digits[i])] = 1;
        }

        // 一位数的 n 可以直接返回
        if (n / 10 == 0)
            return less_than_d[n] + d_arr[n];

        // 将 n 打平存入数组
        int n_len = 0;
        int[] n_arr = new int[10];
        while (n != 0) {
            n_arr[n_len] = n % 10;
            n_len += 1;
            n = n / 10;
        }

        // 把各种幂算出来备用，n_pow[2] 里存的是平方
        int[] n_pow = new int[n_len];
        n_pow[0] = 1;
        for (int i = 1; i < n_len; i++)
            ans += (n_pow[i] = digits.length * n_pow[i - 1]);

        // 将所有可能性加起来
        ans += less_than_d[n_arr[n_len - 1]] * n_pow[n_len - 1];
        for (int i = n_len - 1; i >= 0; i--)
            if (d_arr[n_arr[i]] == 1)
                ans = i == 0 ? ans + 1 : ans + less_than_d[n_arr[i - 1]] * n_pow[i - 1];
            else
                break;


        return ans;
    }
}
