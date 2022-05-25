package com.study.demo;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class Demo {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
