package com.study.leetcode1_100.leetcode26_50;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 *
 * @author jianghui
 * @date 2020-09-28  14:48
 **/
public class LeetCode40 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sq = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(Integer num : candidates){
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]){
                freq.add(new int[]{num,1});
            }else {
                freq.get(size - 1)[1] ++;
            }
        }
        dfs(0,target);
        return res;
    }
    private void dfs(int index,int target){
        if (target == 0){
            res.add(new ArrayList<>(sq));
            return;
        }
        //如果目标值已经小于当前index的值，进行剪枝操作
        if (index == freq.size() || target < freq.get(index)[0]){
            return;
        }

        //不选择该元素
        dfs(index+1,target);
        //选择该元素
        int most = Math.min(target / freq.get(index)[0],freq.get(index)[1]);
        //该元素最多可添加的次数，将数组中的所有重复的元素一起考虑
        for (int i = 1;i <= most;i++){
            sq.add(freq.get(index)[0]);
            dfs(index+1,target-i*freq.get(index)[0]);
        }
        //进行回溯
        for (int i = 1; i <= most;i++){
            sq.remove(sq.size() - 1);
        }
    }
}
