package com.study.leetcode201_300.LeetCode251_275;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode260 {
    /**
     * 常规哈希表
     *
     * @param nums
     * @return
     */
    public int[] singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result.add(key);
            }
        }
        return new int[]{result.get(0), result.get(1)};
    }

    /**
     * 位运算法
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        //异或的和
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        int lsb = (xorsum == Integer.MAX_VALUE ? xorsum : xorsum & (-xorsum));
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

}
