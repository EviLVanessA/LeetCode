package com.study.leetcode301_400.LeetCode326_350;

import java.util.HashSet;
import java.util.Set;

/**
 * 查找俩个数组中的重复元素的个数  相关题 242 202 290 205 451
 *
 * @author jianghui
 * @date 2020-09-15  17:06
 **/
public class LeetCode349 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,1,2,3};
        int[] arr2 = {1,2,2,2,3,3,5,5,6,7};
        int[] res = intersection(arr1,arr2);
        for (Integer num :
                res) {
            System.out.print(num + " ");
        }
    }

    public static int[] intersection(int[] nums1,int[] nums2){
        Set<Integer> record = new HashSet<>();
        for (int item : nums1) {
            record.add(item);
        }
        Set<Integer> result = new HashSet<>();
        for (int value : nums2) {
            if (record.contains(value)) {
                result.add(value);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }
        return res;
    }
}
