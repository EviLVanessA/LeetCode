package com.study.LeetCode1801_1900;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-06-05 10:44
 */
public class LeetCode6092 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int oldIndex = map.get(operation[0]);
            nums[oldIndex] = operation[1];
            map.remove(operation[0]);
            map.put(operation[1], oldIndex);
        }
        return nums;
    }
}
