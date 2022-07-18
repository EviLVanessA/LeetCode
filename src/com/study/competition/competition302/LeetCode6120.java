package com.study.competition.competition302;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-07-17 10:30
 */
public class LeetCode6120 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int num : nums) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        int re = 0;
        for (Integer key : ans.keySet()) {
            int integer = ans.get(key);
            pairs += (integer / 2);
            re += (integer % 2);
        }
        return new int[]{pairs, re};
    }
}
