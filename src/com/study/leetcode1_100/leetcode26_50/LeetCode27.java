package com.study.leetcode1_100.leetcode26_50;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author jianghui
 * @date 2020-09-27  11:02
 **/
public class LeetCode27 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(new LeetCode27().removeElement(arr,3));
    }
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, sum = 0;
        while (j < nums.length){
            if (nums[j] == val){
                j++;
            }else {
                nums[i++] = nums[j++];
                sum++;
            }
        }
        return sum;
    }
}
