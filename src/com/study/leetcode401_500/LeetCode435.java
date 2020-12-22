package com.study.leetcode401_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 1、可以认为区间的终点总是大于它的起点。
 * 2、区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * @author jianghui
 * @date 2020-09-21  9:45
 **/
public class LeetCode435 {

    /**
     * 动态规划解决问题 看做最长上升子序列问题
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[] memory = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            memory[i] = 1;
        }
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i ;j++){
                if (intervals[i][0] >= intervals[j][1]){
                    memory[i] = Math.max(memory[i],1 + memory[j]);
                }
            }
        }
        int res = 0;
        for (int value : memory) {
            res = Math.max(res, value);
        }
        return res;
    }

    /**
     * 贪心算法 每个区间如果结尾最早则后边可容纳更多的区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int res = 1;
        int end = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[end][1]){
                end = intervals[i][1];
                res ++;
            }
        }
        return intervals.length - res;
    }
}