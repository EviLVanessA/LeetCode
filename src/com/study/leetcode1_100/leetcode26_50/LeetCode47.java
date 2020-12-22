package com.study.leetcode1_100.leetcode26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-11 11:16
 */
public class LeetCode47 {
    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        back(nums,ans,0,new ArrayList<>());
        return ans;
    }

    private void back(int[] nums, List<List<Integer>> ans, int index, List<Integer> perm) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            visit[i] = true;
            back(nums,ans,index+1,perm);
            //回溯 还原状态
            visit[i] = false;
            perm.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new LeetCode47().permuteUnique(nums));
    }
}
