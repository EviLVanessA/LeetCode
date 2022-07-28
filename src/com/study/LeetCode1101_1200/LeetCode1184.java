package com.study.LeetCode1101_1200;

/**
 * @author jianghui
 * @date 2022-07-24 09:42
 */
public class LeetCode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i < start || i >= destination) {
                ans1 += distance[i];
            } else {
                ans2 += distance[i];
            }
        }
        return Math.min(ans1, ans2);
    }
}
