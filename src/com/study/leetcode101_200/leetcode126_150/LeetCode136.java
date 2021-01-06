package com.study.leetcode101_200.leetcode126_150;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-01-06 16:44
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
