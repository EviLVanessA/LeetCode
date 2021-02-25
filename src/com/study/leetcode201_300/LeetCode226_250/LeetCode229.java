package com.study.leetcode201_300.LeetCode226_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素
 *
 * @author jianghui
 * @date 2021-02-25 16:30
 */
public class LeetCode229 {
    /**
     * HashMap法
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i : nums) {
            memory.put(i, memory.getOrDefault(i, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int flag = n / 3;
        for (Integer key : memory.keySet()) {
            int value = memory.get(key);
            if (value > flag) {
                ans.add(key);
            }
        }
        return ans;
    }

    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
                continue;
            }
            if (candidate2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }
}
