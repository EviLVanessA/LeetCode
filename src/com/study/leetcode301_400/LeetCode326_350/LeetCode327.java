package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/6/21
 */
public class LeetCode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        return mergeSort(preSum, 0, preSum.length - 1, lower, upper);
    }

    private int mergeSort(long[] preSum, int left, int right, int lower, int upper) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int n1 = mergeSort(preSum, left, mid, lower, upper);
        int n2 = mergeSort(preSum, mid + 1, right, lower, upper);
        int i = left, l = mid + 1, r = mid + 1;
        int ans = n1 + n2;
        while (i <= mid) {
            while (l <= right && preSum[l] - preSum[i] < lower) {
                l++;
            }
            while (r <= right && preSum[r] - preSum[i] <= upper) {
                r++;
            }
            ans += (r - l);
            i++;
        }
        long[] sorted = new long[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = preSum[p2++];
            } else if (p2 > right) {
                sorted[p++] = preSum[p1++];
            } else if (preSum[p1] > preSum[p2]) {
                sorted[p++] = preSum[p2++];
            } else {
                sorted[p++] = preSum[p1++];
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            preSum[left + j] = sorted[j];
        }
        return ans;
    }
}
