package com.study.leetcode201_300.LeetCode276_300;

public class LeetCode278 {
    public int firstBadVersion(int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return mid == 1;
    }
}
