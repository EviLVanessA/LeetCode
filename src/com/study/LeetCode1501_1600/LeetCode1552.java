package com.study.LeetCode1501_1600;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/16
 */
public class LeetCode1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n - 1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pre = position[0], count = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - pre >= mid) {
                    pre = position[i];
                    count++;
                }
            }
            if (count >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
