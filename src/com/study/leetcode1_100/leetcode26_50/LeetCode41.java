package com.study.leetcode1_100.leetcode26_50;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * @author jianghui
 * @date 2020-09-28  15:16
 **/
public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648};
        System.out.println(new LeetCode41().firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 0 || nums[n-1] < 0){
            return 1;
        }
        int k = 0;
        int sum = 0;
        for (int i = 1;i < n;i++){
            if (nums[sum] != nums[i]){
                nums[++sum] = nums[i];
            }
        }
        for (int i = 0; i <= sum; i++) {
            if (nums[i] <= 0){
                k++; 
            }else {
                if (nums[i] != i - k + 1){
                    return i- k + 1;
                }
            }
        }
        return nums[n - 1] + 1;
    }

    /**
     * 时间复杂度 O(n)
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        //对数据进行置换
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
