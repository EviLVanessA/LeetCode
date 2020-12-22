package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-21 16:35
 */
public class LeetCode78 {
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0,nums,ans,new ArrayList<>());
        return ans;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backTrack(j+1,nums,ans,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new LeetCode78().subsets(new int[]{1, 2, 3, 4, 5});
        for(List<Integer> list : subsets){
            System.out.println(list.toString());
        }
    }
}
