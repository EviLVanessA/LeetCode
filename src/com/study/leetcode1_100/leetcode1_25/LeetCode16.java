package com.study.leetcode1_100.leetcode1_25;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @author jianghui
 * @date 2020-09-25  10:09
 **/
public class LeetCode16 {
    public static void main(String[] args) {
        int[] num = {0,2,1,-3};
        System.out.println(new LeetCode16().threeSumClosest(num,1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int minTarget =  Math.abs(nums[0] + nums[1] + nums[2] - target);
        int minNum = nums[0] + nums[1] + nums[2];
        //遍历第一个元素
        for (int one = 0; one < len; one++) {
            if (one > 0 && nums[one] == nums[one - 1]){
                continue;
            }
            //遍历第二和第三个元素
            for (int two = one + 1; two < len; two++) {
                int three = len - 1;
                if (two > one + 1 && nums[two] == nums[two - 1]){
                    continue;
                }
                if (two == three) {
                    break;
                }
                while (two < three){
                    int newMinTarget = Math.abs(nums[one] + nums[two] + nums[three] - target);
                    if (newMinTarget == 0){
                        return target;
                    }
                    if (newMinTarget < minTarget){
                        minTarget = newMinTarget;
                        minNum = nums[one] + nums[two] + nums[three];
                    }
                    three--;
                }
            }
        }
        return minNum;
    }

    /**
     * 执行快
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int left;
        int right;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                //取最小值
                sum = nums[i] + nums[left] + nums[left + 1];
                if (sum > target) {
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    break;
                }
                //取最大值
                sum = nums[i] + nums[right - 1] + nums[right];
                if (sum < target) {
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    break;
                }
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else {
                    left++;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            while(i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
