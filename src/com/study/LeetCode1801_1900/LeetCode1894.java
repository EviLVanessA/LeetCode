package com.study.LeetCode1801_1900;

/**
 * @author jianghui
 * @date 2022-06-11 12:03
 */
public class LeetCode1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                preSum[0] = chalk[0];
            } else {
                preSum[i] = chalk[i] + preSum[i - 1];
            }
            if (chalk[i] > k) {
                return i;
            }
        }
        int left = 0, right = n - 1;
        int ans = 0;
        long yushu = (long) k % preSum[n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] > yushu) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
