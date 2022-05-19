package com.study.leetcode401_500;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/19
 */
public class LeetCode462 {
    public int minMoves1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int target = nums[n / 2];
        for (int num : nums) {
            ans += Math.abs(target - num);
        }
        return ans;
    }

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int targetIndex = findk(nums, 0, nums.length, n / 2);
        int target = nums[targetIndex];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(target - num);
        }
        return ans;
    }

    /**
     * 分区
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] nums, int start, int end) {
        int base = nums[end];
        int p = start;
        while (p < end) {
            if (nums[p] > base) {
                int temp = nums[p];
                nums[p] = nums[start];
                nums[start] = temp;
                start++;
            }
            p++;
        }
        nums[end] = nums[start];
        nums[start] = base;
        return start;
    }

    public int findk(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        if (index == k) {
            return index;
        } else if (index > k) {
            return findk(nums, start, index - 1, k);
        } else {
            return findk(nums, index + 1, end, k);
        }
    }
}

