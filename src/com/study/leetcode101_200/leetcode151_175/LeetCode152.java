package com.study.leetcode101_200.leetcode151_175;

/**
 * 乘积最大子数组
 *
 * @author jianghui
 * @date 2021-01-08 12:28
 */
public class LeetCode152 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        System.arraycopy(nums, 0, dpMax, 0, nums.length);
        System.arraycopy(nums, 0, dpMin, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i], dpMax[i - 1] * nums[i]));
        }
        int ans = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, dpMax[i]);

        }
        return ans;
    }

    /**
     * 由于当前状态只和上一次有关 则可以使用滚动数组进行 空间复杂度优化
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int dpMax = nums[0], dpMin = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int oldMax = dpMax, oldMin = dpMin;
            dpMax = Math.max(oldMax * nums[i], Math.max(nums[i], oldMin * nums[i]));
            dpMin = Math.min(oldMin * nums[i], Math.min(nums[i], oldMax * nums[i]));
            ans = Math.max(dpMax, ans);
        }
        return ans;
    }
}
