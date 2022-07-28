package com.study.LeetCode1301_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-07-28 07:59
 */
public class LeetCode1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        if (arr.length == 1) {
            arr[0] = 1;
            return arr;
        }
        //克隆数组
        int[] clone = arr.clone();
        //排序
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int num = clone[0];
        int index = 1;
        map.put(clone[0], index);
        //数组->编号 存放到哈希表中
        for (int i = 1; i < clone.length; i++) {
            if (num != clone[i]) {
                map.put(clone[i], ++index);
                num = clone[i];
            }
        }
        //替换num
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public int[] arrayRankTransform2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        if (arr.length == 1) {
            arr[0] = 1;
            return arr;
        }
        //克隆数组
        int[] clone = arr.clone();
        //排序
        Arrays.sort(clone);
        int[] map = new int[1 << 18];
        int num = clone[0];
        int index = 1;
        if (clone[0] > 0) {
            map[clone[0] << 9] = index;
        } else {
            map[-clone[0]] = index;
        }
        //数组->编号 存放到哈希表中
        for (int i = 1; i < clone.length; i++) {
            if (num != clone[i]) {
                if (clone[0] > 0) {
                    map[clone[0] << 9] = ++index;
                } else {
                    map[-clone[0]] = ++index;
                }
                num = clone[i];
            }
        }
        //替换num
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = map[arr[i] << 9];
            } else {
                arr[i] = map[-arr[i]];
            }
        }
        return arr;
    }
}
