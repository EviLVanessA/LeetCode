package com.study.LeetCode901_1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-05-21 10:21
 */
public class LeetCode961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> count = new HashSet<>();
        for (int num : nums) {
            if (count.contains(num)) {
                return num;
            } else {
                count.add(num);
            }
        }
        return -1;
    }

    public int repeatedNTimes2(int[] nums) {
        int step = 3;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= step; j++) {
                if (i + j < nums.length && nums[i] == nums[i + j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
