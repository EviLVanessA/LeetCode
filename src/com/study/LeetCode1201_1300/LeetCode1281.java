package com.study.LeetCode1201_1300;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/16
 */
public class LeetCode1281 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 1, right = max;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                count += (num - 1) / mid + 1;
            }
            if (count <= threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
