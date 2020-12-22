package com.study.leetcode1_100.leetcode26_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * @author jianghui
 * @date 2020-09-28  14:13
 **/
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,res,combine,0);
        return res;
    }
    private void dfs (int[] candidates,int target, List<List<Integer>> res,List<Integer> combine,int index){
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(combine));
            return;
        }
        //不考虑当前元素
        dfs(candidates,target,res,combine,index + 1);

        //考虑当前元素
        if (target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],res,combine,index);
            combine.remove(combine.size() - 1);
        }
    }
}
