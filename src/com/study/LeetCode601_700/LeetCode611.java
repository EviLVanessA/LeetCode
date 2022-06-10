package com.study.LeetCode601_700;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-10 10:09
 */
public class LeetCode611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
                for (int j = i + 1; j < n; ++j) {
                    while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                        ++k;
                    }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}
