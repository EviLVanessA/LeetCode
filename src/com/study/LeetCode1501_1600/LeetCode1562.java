package com.study.LeetCode1501_1600;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/22
 */
public class LeetCode1562 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[][] endPoints = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(endPoints[i], -1);
        }
        int count = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int left = arr[i], right = arr[i];
            if (arr[i] > 1 && endPoints[arr[i] - 1][0] != -1) {
                left = endPoints[arr[i] - 1][0];
                int leftLength = endPoints[arr[i] - 1][1] - endPoints[arr[i] - 1][0] + 1;
                if (leftLength == m) {
                    count--;
                }
            }
            if (arr[i] < n && endPoints[arr[i] + 1][1] != -1) {
                right = endPoints[arr[i] + 1][1];
                int rightLength = endPoints[arr[i] + 1][1] - endPoints[arr[i] + 1][0] + 1;
                if (rightLength == m) {
                    count--;
                }
            }
            int length = right - left + 1;
            if (length == m) {
                count++;
            }
            if (count > 0) {
                ans = i + 1;
            }
            endPoints[left][0] = endPoints[right][0] = left;
            endPoints[left][1] = endPoints[right][1] = right;
        }
        return ans;
    }

    public int findLatestStep2(int[] arr, int m) {
        int count = 0;
        int ans = -1;
        int[] link = new int[arr.length + 2];
        Arrays.fill(link, -1);
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int left = link[cur - 1] != -1 ? link[cur - 1] : cur;
            int right = link[cur + 1] != -1 ? link[cur + 1] : cur;
            if (cur - left == m) {
                count--;
            }
            if (right - cur == m) {
                count--;
            }
            if (right - left + 1 == m) {
                count++;
            }
            if (count > 0) {
                ans = i;
            }
            link[left] = right;
            link[right] = left;
        }
        return ans;
    }
}
