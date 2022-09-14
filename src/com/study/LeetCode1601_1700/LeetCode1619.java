package com.study.LeetCode1601_1700;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/9/13
 */
public class LeetCode1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int removeCount = (int) (n * 0.05);
        int sum = 0;
        for (int i = removeCount; i < n - removeCount; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (n - 2 * removeCount);
    }
}
