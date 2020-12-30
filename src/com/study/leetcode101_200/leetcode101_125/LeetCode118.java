package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-29 18:44
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
