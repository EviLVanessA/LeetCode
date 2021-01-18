package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * @author jianghui
 * @date 2021-01-18 15:25
 */
public class LeetCode210 {
    private List<List<Integer>> edges;
    private int[] visited;
    private List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        ans = new ArrayList<>();
        //为每个节点添加边
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (ans.size() == numCourses) {
            int[] arr = new int[ans.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ans.get(ans.size() - i - 1);
            }
            return arr;
        }
        return new int[]{};
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int v : edges.get(i)) {
            if (visited[v] == 0) {
                dfs(v);
            } else if (visited[v] == 1) {
                return;
            }
        }
        visited[i] = 2;
        ans.add(i);
    }
}
