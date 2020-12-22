package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组，并在使用 O(1)额外空间的条件下完成。
 *
 *
 * @author jianghui
 * @date 2020-09-27  10:39
 **/
public class LeetCode26 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,4};
        System.out.println(new LeetCode26().removeDuplicates(arr));
    }
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        int num = 1;
        while (j <nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[++i] = nums[j];
                num++;
            }
        }
        return num;
    }
}
