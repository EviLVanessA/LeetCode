package com.study.competition.competition299;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-26 10:41
 */
public class LeetCode5229 {
    public int maximumsSplicedArray2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] preSum1 = new int[n + 1];
        int[] preSum2 = new int[n + 1];
        preSum1[0] = 0;
        preSum2[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum1[i + 1] = preSum1[i] + nums1[i];
            preSum2[i + 1] = preSum2[i] + nums2[i];
        }
        int max = Math.max(preSum1[n], preSum2[n]);
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int sum1 = preSum1[j] - preSum1[i];
                int sum2 = preSum2[j] - preSum2[i];
                int curSum1 = preSum1[n] - sum1 + sum2;
                int curSum2 = preSum2[n] - sum2 + sum1;
                max = Math.max(Math.max(curSum1, curSum2), max);
            }
        }
        return max;
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(max(nums1, nums2), max(nums2, nums1));
    }

    public int max(int[] nums1, int[] nums2) {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += (nums2[i] - nums1[i]);
            if (sum < 0) {
                sum = 0;
            }
            temp = Math.max(temp, sum);
        }
        int sum1 = Arrays.stream(nums1).sum();
        return sum1 + temp;
    }
}
