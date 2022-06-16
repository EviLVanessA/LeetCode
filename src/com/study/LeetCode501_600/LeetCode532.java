package com.study.LeetCode501_600;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-06-15 20:49
 */
public class LeetCode532 {

    public int findPairs1(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>((int) 1e4);
        //用set去重
        Set<Integer> ans = new HashSet<>((int) 1e4);
        //只存放数对(x,y)中的x即可
        for (int num : nums) {
            if (numSet.contains(num - k)) {
                ans.add(num - k);
            }
            if (numSet.contains(num + k)) {
                ans.add(num);
            }
            numSet.add(num);
        }
        return ans.size();
    }

    public int findPairs2(int[] nums, int k) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            //重复的不计算，如果相同nums[i-1]已经计算过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] + k;
            //在[i+1,n-1]中找target
            int left = i + 1, right = n - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //判断是否找到
            if (ans != -1 && nums[ans] == target) {
                res++;
            }
        }
        return res;
    }

    public int findPairs3(int[] nums, int k) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n - 1 && j < n; i++) {
            //重复的不计算，如果相同nums[i-1]已经计算过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //需要j > i，有可能去重时导致i >= j
            while (j <= i) {
                j++;
            }
            //找到target 和方法二一样，只找nums[i] + k
            while (j < n && (nums[j] < nums[i] + k)) {
                j++;
            }
            //找到目标值
            if (j < n && nums[j] == nums[i] + k) {
                res++;
            }
        }
        return res;
    }
}
