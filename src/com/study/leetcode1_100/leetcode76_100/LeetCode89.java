package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-22 17:05
 */
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }
    public List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> list = new LeetCode89().grayCode2(3);
        for(Integer i : list){
            System.out.println(i);
        }
//        int head = 1;
//        head <<= 1;
//        head <<= 1;
//        System.out.println(head);
    }
}
