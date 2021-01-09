package com.study.leetcode101_200.leetcode151_175;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-01-09 15:03
 */
public class LeetCode169 {
    /**
     * 采用哈希表 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int num : nums) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }
        for (Integer i : ans.keySet()) {
            if (ans.get(i) > (nums.length / 2)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169().majorityElement(new int[]{3, 2, 3}));
    }
}
