package com.study.competition.competition296;

/**
 * @author jianghui
 * @date 2022-06-05 10:31
 */
public class LeetCode6090 {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] newNums = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6090().minMaxGame(new int[]{3}));
    }
}
