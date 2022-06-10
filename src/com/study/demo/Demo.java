package com.study.demo;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (left < nums.length) {
            if (sum < target && right + 1 < nums.length) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
