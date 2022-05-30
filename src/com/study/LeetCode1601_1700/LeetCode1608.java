package com.study.LeetCode1601_1700;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/30
 */
public class LeetCode1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            int left = 0, right = nums.length - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= i) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (ans != -1 && nums.length - ans == i) {
                return i;
            }
        }
        return -1;
    }

    public int specialArray2(int[] nums) {
        int left = 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int right = Math.max(max, nums.length);
        while (left <= right) {
            int mid = (left + right) / 2;
            int bigger = 0;
            for (int num : nums) {
                if (num >= mid) {
                    bigger++;
                }
            }
            if (bigger == mid) {
                return mid;
            } else if (bigger > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode1608().specialArray(new int[]{0,4,3,0,4}));
    }
}
