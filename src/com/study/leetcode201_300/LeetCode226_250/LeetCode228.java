package com.study.leetcode201_300.LeetCode226_250;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-02-25 16:15
 */
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            List<String> ans = new ArrayList<>();
            ans.add(nums[0] + "");
            return ans;
        }
        List<String> ans = new ArrayList<>();
        int left = nums[0], right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (right + 1 == nums[i]) {
                right++;
            } else {
                if (left == right) {
                    ans.add(left + "");
                } else {
                    ans.add(left + "->" + right);
                }
                left = nums[i];
                right = nums[i];
            }
        }
        if (left == right) {
            ans.add(left + "");
        } else {
            ans.add(left + "->" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> list = new LeetCode228().summaryRanges(nums);
        for (String str : list){
            System.out.println(str);
        }
    }
}
