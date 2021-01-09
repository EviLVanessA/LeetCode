package com.study.leetcode101_200.leetcode151_175;

/**
 * @author jianghui
 * @date 2021-01-08 14:28
 */
public class LeetCode154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //中间的数小于右边的数 说明 右侧有序 则直接抛掉右边的数据
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            //中间的数大于右侧的数 说明最小值再右侧
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            //两者相等无法判断 但是 可抛去右侧数据
            else {
                right--;
            }
        }
        return nums[left];
    }
}
