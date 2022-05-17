package com.study.leetcode301_400.LeetCode301_325;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/17
 */
public class LeetCode315 {
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }
//
//    private int[] c;
//    private int[] a;
//
//    public List<Integer> countSmaller(int[] nums) {
//
//    }


}
