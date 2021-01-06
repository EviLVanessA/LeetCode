package com.study.leetcode101_200.leetcode126_150;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * @author jianghui
 * @date 2021-01-06 17:11
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;

        for (int num : nums) {
            one = ~two & (one ^ num);
            two = ~one & (two ^ num);
        }

        return one;
    }
}
