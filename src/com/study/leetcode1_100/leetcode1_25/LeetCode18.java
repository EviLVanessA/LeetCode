package com.study.leetcode1_100.leetcode1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * @author jianghui
 * @date 2020-09-25  10:48
 **/
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //遍历第一个元素
        for (int one = 0; one < len; one++) {
            int flag = 0;
            if (one > 0 && nums[one] == nums[one - 1]){
                continue;
            }
            //遍历第二个元素
            int target1 = target - nums[one];
            for (int two = one + 1; two < len; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]){
                    continue;
                }
                int target2 = target1 - nums[two];
                int four = len - 1;
                for (int three = two + 1; three < len; three++) {
                    if (three > two + 1 && nums[three] == nums[three - 1]){
                        continue;
                    }
                    //如果加起来还没有目标值大 后边就没有了
                    while (three < four && nums[three] + nums[four] > target2){
                        four --;
                    }
                    if (three == four){
                        break;
                    }

                    if (nums[three] + nums[four] == target2){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[one]);
                        list.add(nums[two]);
                        list.add(nums[three]);
                        list.add(nums[four]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
