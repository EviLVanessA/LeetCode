package com.study.leetcode401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找表
 * @author jianghui 49
 * @date 2020-09-16  9:19
 **/
public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> record = new HashMap<>();
        for (int element : C) {
            for (int value : D) {
                int sum = element + value;
                record.put(sum, record.containsKey(sum) ? record.get(sum) + 1 : 1);
            }
        }
        int res = 0;
        for (int item : A) {
            for (int value : B) {
                int sum = -item - value;
                if (record.containsKey(sum)) {
                    res += record.get(sum);
                }
            }
        }
        return res;
    }
}
