package com.study.leetcode401_500;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/20
 */
public class LeetCode436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startToIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            startToIndex[i][0] = intervals[i][0];
            startToIndex[i][1] = i;
        }
        Arrays.sort(startToIndex, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (startToIndex[mid][0] >= intervals[i][1]) {
                    target = startToIndex[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }
}
