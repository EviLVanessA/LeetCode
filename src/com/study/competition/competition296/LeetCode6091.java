package com.study.competition.competition296;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-05 10:37
 */
public class LeetCode6091 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                ans++;
                min = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6091().partitionArray(new int[]{2, 2, 4, 5}, 0));
    }
}
