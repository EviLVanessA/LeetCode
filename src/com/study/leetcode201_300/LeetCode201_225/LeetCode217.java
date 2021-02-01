package com.study.leetcode201_300.LeetCode201_225;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author jianghui
 * @date 2021-02-01 11:11
 */
public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int num : nums){
            if (ans.contains(num)){
                return true;
            }else {
                ans.add(num);
            }
        }
        return false;
    }
}
