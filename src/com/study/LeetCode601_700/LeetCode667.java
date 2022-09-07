package com.study.LeetCode601_700;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/9/7
 */
public class LeetCode667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 0;
        int p = 1, q = n;
        for (int j = 0; j < k; j++) {
            if (j % 2 == 0) {
                ans[i++] = p++;
            } else {
                ans[i++] = q--;
            }
        }
        if (k % 2 == 0) {
            while (i < n) {
                ans[i++] = q--;
            }
        } else {
            while (i < n) {
                ans[i++] = p++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(new LeetCode667().constructArray(100, 5)));
        System.out.println(System.currentTimeMillis() - start);
    }
}
