package com.study.leetcode101_200.leetcode126_150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2021-01-04 14:33
 */
public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                max = Math.max(sum, max);
                sum = 1;
            }
        }
        return Math.max(sum, max);
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curStreak  = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curStreak ++;
                }
                longStreak = Math.max(longStreak,curStreak);
            }
        }
        return longStreak;
    }
}
