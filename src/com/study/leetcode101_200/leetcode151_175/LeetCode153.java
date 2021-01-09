package com.study.leetcode101_200.leetcode151_175;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author jianghui
 * @date 2021-01-08 13:52
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearch(nums, left, right);
    }

    private int binarySearch(int[] nums, int left, int right) {
        //index相等 直接返回
        if (left == right){
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        //判断当前序列是否有序 若有序 有序直接返回
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            if (nums[left] > nums[mid]) {
                //此时如果左序列 不是有序的 则最小值在左序列
                return binarySearch(nums, left, mid);
            } else {
                //否则 最小值再右序列
                return binarySearch(nums, mid + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode153 l = new LeetCode153();
        System.out.println(l.findMin(new int[]{10,1,10,10,10}));
    }
}
