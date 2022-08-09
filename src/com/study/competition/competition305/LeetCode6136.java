package com.study.competition.competition305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-08-07 10:30
 */
public class LeetCode6136 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + diff + diff)) {
                count++;
            }
        }
        return count;
    }
}
