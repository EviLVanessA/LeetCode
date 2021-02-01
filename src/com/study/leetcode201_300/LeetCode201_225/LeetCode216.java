package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * @author jianghui
 * @date 2021-01-28 16:10
 */
public class LeetCode216 {
    /**
     * 保存最终的答案
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, 1, n, new ArrayList<>());
        return ans;
    }

    /**
     * 回溯法解决组合问题
     * @param k 最多达到的个数
     * @param index 当前的索引
     * @param target 目标值为多少
     * @param temp 当前临时存储答案的list
     */
    private void backTrack(int k, int index, int target, List<Integer> temp) {
        //如果当前list达到目标个数
        if (temp.size() == k ) {
            //如果当前的目标值为0 表示符合答案要求
            if (target == 0){
                //将答案保存
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            //目标值不大于i直接进行剪枝
            if (target >= i){
                //添加当前数据 由于 不允许有重复 所以要从index往下遍历
                temp.add(i);
                //递归调用
                backTrack(k, i + 1, target - i, temp);
                //将当前数据移除临时的list
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode216().combinationSum3(3, 9));
    }
}
