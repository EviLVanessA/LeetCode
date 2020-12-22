package com.study.leetcode1_100.leetcode51_75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-14 09:18
 */
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                ans.add(new int[]{interval[0], interval[1]});

            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        ans.sort(Comparator.comparingInt(o -> o[0]));
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
