package com.study.competition.competition301;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-07-10 10:30
 */
public class LeetCode6112 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int ans = 0;
        while (amount[2] > 0 && amount[1] > 0) {
            ans++;
            amount[2]--;
            amount[1]--;
            Arrays.sort(amount);
        }
        ans += amount[2];
        return ans;
    }
}
