package com.study.LeetCode1301_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022/7/27
 */
public class LeetCode1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;
        for (int i1 : clone) {
            if (!map.containsKey(i1)) {
                map.put(i1, i);
                i++;
            }
        }
        for (int i1 = 0; i1 < clone.length; i1++) {
            clone[i1] = map.get(arr[i1]);
        }
        return clone;
    }
}
