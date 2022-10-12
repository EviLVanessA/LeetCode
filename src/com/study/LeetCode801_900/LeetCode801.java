package com.study.LeetCode801_900;

/**
 * @author jianghui
 * @date 2022/10/9
 */
public class LeetCode801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                //当前数字大于前一个数字
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    //当前数字大于另一个数组的前一个数字

                    //前一个交换不交换都无所谓
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    //交换 + 1
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else {
                    //当前数字不大于另一个数组的前一个数字

                    //当前数字不交换，上一个也不能交换
                    dp[i][0] = dp[i - 1][0];
                    //当前数字交换，上一个也必须交换
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                //当前数字不大于前一个数字

                //本次不交换 则上一次交换
                dp[i][0] = dp[i - 1][1];
                //本次交换 则上一次不交换
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minSwap2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] >= nums2[i] || nums2[i - 1] >= nums1[i]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            } else if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                int min = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = min + 1;
                dp[i][0] = min;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minSwap3(int[] nums1, int[] nums2) {
        int dp1 = 1, dp0 = 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] >= nums2[i] || nums2[i - 1] >= nums1[i]) {
                dp1++;
            } else if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                int temp = dp1;
                dp1 = dp0 + 1;
                dp0 = temp;
            } else {
                int min = Math.min(dp0, dp1);
                dp1 = min + 1;
                dp0 = min;
            }
        }
        return Math.min(dp0, dp1);
    }
}
