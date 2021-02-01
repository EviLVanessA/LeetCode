package com.study.leetcode201_300.LeetCode276_300;

import java.util.Arrays;

/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * @author jianghui
 * @date 2020-09-19  16:59
 **/
public class LeetCode300 {
    /**
     * 动态规划O(n^2)
     * 存在O(n*logn)的时间复杂度算法 不是动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]表示以nums[i]结尾的最长自增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * 二分搜索  纸牌游戏
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        //牌堆数
        int piles = 0;
        for (int poker : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {
        int[] nums = {6,3,5,10,11,2,9,14,13,7,4,8,12};
        System.out.println(new LeetCode300().lengthOfLIS2(nums));
    }
}
