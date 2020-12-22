package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用回溯解决组合问题
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 相关题 39 40 216 78 90 401
 * @author jianghui
 * @date 2020-09-18  11:02
 **/
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n){
            return res;
        }
        List<Integer> c = new ArrayList<>();
        generateCombinations(n,k,1,c,res);
        return res;
    }
    public void generateCombinations(int n,int k,int start,List<Integer> c,List<List<Integer>> res){
        if (c.size() == k){
            res.add(new ArrayList<>(c));
            return;
        }
        //i最多为n-(k-c.size())+1  故进行剪枝操作
        for (int i = start; i <= n-(k-c.size())+1; i++) {
            c.add(i);
            generateCombinations(n,k,i+1,c,res);
            c.remove(c.size()-1);
        }

    }
}
