package com.study.leetcode301_400.LeetCode326_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求两个数组的交集
 *
 * @author jianghui
 * @date 2020-09-15  17:17
 **/
public class LeetCode350 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3};
        int[] arr2 = {1, 2, 2, 2, 3, 3, 5, 5, 6, 7};
        int[] res = intersect(arr1, arr2);
        for (Integer num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();
        for (Integer num : nums1) {
            record.put(num, record.containsKey(num) ? record.get(num) + 1 : 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer num : nums2) {
            if (record.get(num) != null && record.get(num) > 0) {
                res.add(num);
                record.put(num, record.get(num) - 1);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            arr[i++] = num;
        }
        return arr;
    }
}
