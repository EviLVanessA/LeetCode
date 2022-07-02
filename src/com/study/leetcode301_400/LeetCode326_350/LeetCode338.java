package com.study.leetcode301_400.LeetCode326_350;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/29
 */
public class LeetCode338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int count = 0;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode338().countBits(5)));
    }
}
