package com.study.LeetCode701_800;

import com.study.leetcode301_400.LeetCode326_350.LeetCode343;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/7/21
 */
public class LeetCode757 {
    //正序
    public int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int n = intervals.length;
        int cur = intervals[0][1] - 1;
        int next = intervals[0][1];
        int ans = 2;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= cur) {
                continue;
            } else if (intervals[i][0] <= next) {
                ans++;
                cur = next;
                next = intervals[i][1];
            } else {
                ans = ans + 2;
                cur = intervals[i][1] - 1;
                next = intervals[i][1];
            }
        }
        return ans;
    }

    //倒序
    public int intersectionSizeTwo3(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int n = intervals.length;
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        for (int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }
    //错误
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(intervals));
        int n = intervals.length;
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        List<Integer> list = new ArrayList<>();
        list.add(cur);
        list.add(next);
        for (int i = n - 2; i >= 0; i--) {
            System.out.println(Arrays.toString(intervals[i]) + "\t" + list);
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
                list.add(0, next);
                list.add(0, cur);
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
                list.add(0, cur);
            }
        }
        return ans;
    }

    public int intersectionSizeTwo1(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        System.out.println("排序后intervals：" + Arrays.deepToString(intervals));
        int n = intervals.length;
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        List<Integer> list = new ArrayList<>();
        list.add(cur);
        list.add(next);
        for (int i = n - 2; i >= 0; i--) {
            System.out.println("待比较区间：" + Arrays.toString(intervals[i]) + "\t当前集合S：" + list);
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
                list.add(0, next);
                list.add(0, cur);
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
                list.add(0, cur);
            }
        }
        return ans;
    }

    //[[2,10],[3,7],[3,15],[4,11],[6,12],[6,16],[7,8],[7,11],[7,15],[11,12]]
    public static void main(String[] args) {
        int[][] intervals = {{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}};
        System.out.println(new LeetCode757().intersectionSizeTwo1(intervals));
    }
}
