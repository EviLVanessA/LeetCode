package com.study.offer;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-13 21:45
 */
public class offer53 {
    public int missingNumber2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return n * (n - 1) / 2 - sum;
    }

    public int missingNumber(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
