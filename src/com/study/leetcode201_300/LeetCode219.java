package com.study.leetcode201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 * 相关题 217
 * @author jianghui
 * @date 2020-09-16  9:50
 **/
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])){
                return true;
            }
            record.add(nums[i]);
            //保证record中有k个元素
            if (record.size() == k+1){
                record.remove(nums[i-k]);
            }
        }
        return false;
    }
}
