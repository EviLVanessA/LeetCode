package com.study.LeetCode1301_1400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-06-01 21:07
 */
public class LeetCode1346 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.containsKey(0) && map.get(0) > 1) {
            return true;
        }
        for (int i : arr) {
            if (map.containsKey(i * 2) && i != 0) {
                return true;
            }
        }
        return false;
    }
}
