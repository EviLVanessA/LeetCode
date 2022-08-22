package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022/8/19
 */
public class LeetCode1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}
