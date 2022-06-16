package com.study.LeetCode701_800;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-14 21:53
 */
public class LeetCode719 {
    public int smallestDistancePair(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        //找到左右取值范围
        int left = 0, right = nums[n - 1] - nums[0];
        int ans = 0;
        //二分找第K小
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = 0;
            int count = 0;
            //计算当前小于mid的数对有多少
            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            //count小于则left = mid + 1，
            // 大于则right = mid - 1
            if (count >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
