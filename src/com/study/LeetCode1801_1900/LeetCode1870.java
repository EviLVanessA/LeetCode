package com.study.LeetCode1801_1900;

/**
 * @author jianghui
 * @date 2022/6/20
 */
public class LeetCode1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour) {
            return -1;
        }
        int left = 1, right = (int) 1e9;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (costTime(dist, mid) > hour) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public double costTime(int[] dist, int speed) {
        int n = dist.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                sum += dist[i] / (double) speed;
            } else {
                sum += (dist[i] - 1) / speed + 1;
            }
        }
        return sum;
    }

}
