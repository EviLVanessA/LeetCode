package com.study.LeetCode1001_1100;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-12 18:53
 */
public class LeetCode1051 {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(heights);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) {
                ans++;
            }
        }
        return ans;
    }
}
