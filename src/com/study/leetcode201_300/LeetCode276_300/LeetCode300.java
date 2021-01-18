package com.study.leetcode201_300.LeetCode276_300;

/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 *
 * @author jianghui
 * @date 2020-09-19  16:59
 **/
public class LeetCode300 {
    /**
     * 动态规划O(n^2)
     * 存在O(n*logn)的时间复杂度算法 不是动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        //memory[i]表示已i为结尾的最长公共子序列
        int[] memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    memory[i] = Math.max(memory[i],1+memory[j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, memory[i]);
        }
        return max;
    }
}
