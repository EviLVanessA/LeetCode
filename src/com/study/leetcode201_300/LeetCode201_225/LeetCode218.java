package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * <p>
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <p>
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。
 * 关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。
 * 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <p>
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
 * 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 *
 * @author jianghui
 * @date 2021-02-01 11:28
 */
public class LeetCode218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }
        return merge(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> merge(int[][] buildings, int start, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            temp.add(buildings[start][0]);
            temp.add(buildings[start][2]);
            ans.add(temp);
            temp = new ArrayList<>();
            temp.add(buildings[start][1]);
            temp.add(0);
            ans.add(temp);
            return ans;
        }
        int mid = start + (end - start) / 2;
        List<List<Integer>> skyLineOne = merge(buildings, start, mid);
        List<List<Integer>> skyLineTwo = merge(buildings, mid + 1, end);
        int h1 = 0, h2 = 0, i = 0, j = 0;
        while (i < skyLineOne.size() || j < skyLineTwo.size()) {
            long x1 = i < skyLineOne.size() ? skyLineOne.get(i).get(0) : Long.MAX_VALUE;
            long x2 = j < skyLineTwo.size() ? skyLineTwo.get(j).get(0) : Long.MAX_VALUE;
            long x = 0;
            if (x1 < x2) {
                h1 = skyLineOne.get(i).get(1);
                x = x1;
                i++;
            } else if (x1 > x2) {
                h2 = skyLineTwo.get(j).get(1);
                x = x2;
                j++;
            } else {
                h1 = skyLineOne.get(i).get(1);
                h2 = skyLineTwo.get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            //更新height
            int height = Math.max(h1, h2);
            if (ans.isEmpty() || height != ans.get(ans.size() - 1).get(1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add((int) x);
                temp.add(height);
                ans.add(temp);
            }
        }
        return ans;
    }
}
