package com.study.other;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-07-04 21:35
 */
public class MyCalendar2 {
    List<int[]> data;

    public MyCalendar2() {
        data = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (data.size() == 0) {
            data.add(new int[]{start, end});
            return true;
        }
        data.sort(Comparator.comparingInt(o -> o[0]));
        int left = 0, right = data.size() - 1;
        //找到第一个start >= end的区间
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid)[0] >= end) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //没有找到 和最后一个区间比较
        if (ans == -1) {
            int[] ints = data.get(data.size() - 1);
            if (ints[1] > start) {
                return false;
            }
        } else if (ans != 0) {
            //不是第一个区间，如果是第一个区间则可以直接插入
            int[] pre = data.get(ans - 1);
            if (pre[1] > start) {
                return false;
            }
        }
        data.add(new int[]{start, end});
        return true;
    }
}
