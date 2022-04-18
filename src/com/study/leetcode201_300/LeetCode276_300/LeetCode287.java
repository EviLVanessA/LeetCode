package com.study.leetcode201_300.LeetCode276_300;

public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }

    public static void main(String[] args) {
//        int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(new LeetCode287().findDuplicate(arr));
    }
}
