package com.study.leetcode1_100.leetcode1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  三数之和
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 *  使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 *
 * @author jianghui
 * @date 2020-09-25  9:26
 **/
public class LeetCode15 {
    public List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //寻找第一个元素
        for (int one = 0; one < len; one++) {
            //寻找和上次不同的第一个元素
            if (one > 0 && nums[one] == nums[one - 1]){
                continue;
            }
            //寻找第二个和第三个元素
            int three = len - 1;
            int target = -nums[one];
            for (int two = one + 1; two < len; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]){
                    continue;
                }
                //寻找第三个元素
                while (two < three && nums[two] + nums[three] > target){
                    three --;
                }
                //相等退出循环
                if (two == three) {
                    break;
                }
                if (nums[two] + nums[three] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    res.add(list);
                }
            }
        }
        return res;
    }















    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            // 目标位置
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
