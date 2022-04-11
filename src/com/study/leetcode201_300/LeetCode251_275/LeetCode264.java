package com.study.leetcode201_300.LeetCode251_275;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LeetCode264 {

    /**
     * 最小堆
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        int[] arr = {2, 3, 5};
        //最小堆
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        heap.add(1L);
        set.add(1L);
        int result = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            result = (int) cur;
            for (int j = 0; j < 3; j++) {
                long l = cur * arr[j];
                if (!set.contains(l)) {
                    set.add(l);
                    heap.add(l);
                }
            }
        }
        return result;
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }
}
