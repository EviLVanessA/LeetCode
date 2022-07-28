package com.study.competition.competition303;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-07-24 11:21
 */
public class LeetCode6127 {

    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0L;
        Set<Integer> vis = new HashSet<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            if (!vis.contains(x)) {
                vis.add(x);
                int c = Integer.bitCount(x);
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> x : cnt.entrySet()) {
            for (Map.Entry<Integer, Integer> y : cnt.entrySet()) {
                if (x.getKey() + y.getKey() >= k) {
                    ans += (long) x.getValue() * y.getValue();
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode6127().countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
    }
}
