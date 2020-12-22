package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * @author jianghui
 * @date 2020-09-28  10:42
 **/
public class LeetCode35 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7};
        System.out.println(new LeetCode35().searchInsert(arr,8));
    }
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0] < target ? 1 : 0;
        }

        int l = 0, r = n - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
