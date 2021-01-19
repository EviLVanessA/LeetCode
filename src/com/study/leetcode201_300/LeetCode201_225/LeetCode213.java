package com.study.leetcode201_300.LeetCode201_225;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-01-19 09:14
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        //采用滚动数组优化空间复杂度
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }
}
