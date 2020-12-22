package com.study.leetcode1_100.leetcode26_50;

/**
 * @author jianghui
 * @date 2020-12-10 19:24
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
//        int[] num = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(new LeetCode45().jump(num));
    }
}
