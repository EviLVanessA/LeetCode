package com.study.interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022/8/8
 */
public class Interview1709 {
    public int getKthMagicNumber(int k) {
        int[] nums = {3, 5, 7};
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        visited.add(1L);
        queue.offer(1L);
        int target = 0;
        for (int i = 0; i < k; i++) {
            long poll = queue.poll();
            target = (int) poll;
            for (int num : nums) {
                long cur = poll * num;
                if (!visited.contains(cur)) {
                    visited.add(cur);
                    queue.offer(cur);
                }
            }
        }
        return target;
    }

    public int getKthMagicNumber2(int k) {
        int[] dp = new int[k];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[i1] * 3, Math.min(dp[i2] * 5, dp[i3] * 7));
            if (dp[i] == dp[i1] * 3) {
                i1++;
            }
            if (dp[i] == dp[i2] * 5) {
                i2++;
            }
            if (dp[i] == dp[i3] * 7) {
                i3++;
            }
        }
        return dp[k - 1];
    }
}
