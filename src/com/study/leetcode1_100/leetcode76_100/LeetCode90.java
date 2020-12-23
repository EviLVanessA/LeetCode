package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-23 08:54
 */
public class LeetCode90 {
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Arrays.sort(nums);
        back(0, ans, new ArrayList<>(), nums);
        return ans;
    }

    private void back(int i, List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums) {
        ans.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            //这里是j>i而不是j>0 因为是当前元素往后 进行比较 不和之前的进行比较
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            temp.add(nums[j]);
            back(j + 1, ans, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> lists = new LeetCode90().subsetsWithDup(arr);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
