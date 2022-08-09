package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022-08-09 08:07
 */
public class LeetCode1413 {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return -min + 1;
    }
}
