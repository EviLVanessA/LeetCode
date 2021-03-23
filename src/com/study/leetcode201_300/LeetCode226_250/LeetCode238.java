package com.study.leetcode201_300.LeetCode226_250;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @author jianghui
 * @date 2021-03-03 09:15
 */
public class LeetCode238 {
    /**
     * 空间复杂度为O(n)的解法
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //left[i]表示i左侧元素的乘积 不包括i
        int[] left = new int[n];
        //right[i]表示i右侧元素的乘积 不包括i
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
