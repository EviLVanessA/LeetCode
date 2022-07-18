package com.study.competition.competition302;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jianghui
 * @date 2022-07-17 11:23
 */
public class LeetCode6122 {
    public int minOperations(int[] nums, int[] numsDivide) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int ans = 0;
        int gcd = countDifferentSubsequenceGCDs(numsDivide);
        while (!queue.isEmpty()) {
            int peek = queue.peek();
            if (gcd % peek != 0) {
                queue.poll();
                ans++;
            } else {
                return ans;
            }
        }
        return -1;
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = nums[0];
        for (int num : nums) {
            ans = gcd(num, ans);
        }
        return ans;
    }

    private int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6122().countDifferentSubsequenceGCDs(new int[]{105, 70, 70, 175, 105, 105, 105}));
    }
}
