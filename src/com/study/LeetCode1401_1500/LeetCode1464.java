package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022/8/26
 */
public class LeetCode1464 {
    public int maxProduct(int[] nums) {
        int max = nums[0], secondMax = nums[1];
        if (max < secondMax) {
            int temp = max;
            max = secondMax;
            secondMax = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}
