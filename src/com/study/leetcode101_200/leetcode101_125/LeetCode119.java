package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * @author jianghui
 * @date 2020-12-29 19:26
 */
public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        long[] arr = new long[rowIndex + 1];
        arr[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            arr[i] = arr[i - 1] * (rowIndex - i + 1) / i;
        }
        List<Integer> ans = new ArrayList<>();
        for (long value : arr) {
            ans.add((int) value);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode119().getRow(3));
    }
}
