package com.study.leetcode1_100.leetcode51_75;

import java.util.*;

/**
 * @author jianghui
 * @date 2020-12-11 18:12
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[]{left, right});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
