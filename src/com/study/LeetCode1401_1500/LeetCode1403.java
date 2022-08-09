package com.study.LeetCode1401_1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/8/4
 */
public class LeetCode1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        List<Integer> ans = new ArrayList<>();
        int curSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            if (curSum > sum) {
                break;
            }
        }
        return ans;
    }

    public List<Integer> minSubsequence2(int[] nums) {
        int[] bucket = new int[101];
        int sum = 0;
        for (int num : nums) {
            bucket[num]++;
            sum += num;
        }
        int curSum = 0;
        List<Integer> ans = new ArrayList<>();
        int index = 100;
        while (curSum <= sum) {
            if (bucket[index] > 0) {
                curSum += index;
                sum -= index;
                bucket[index]--;
                ans.add(index);
                if (curSum > sum) {
                    break;
                }
            } else {
                index--;
            }
        }
        return ans;
    }
}
