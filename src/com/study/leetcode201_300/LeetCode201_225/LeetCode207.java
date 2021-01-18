package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * @author jianghui
 * @date 2021-01-18 12:29
 */
public class LeetCode207 {
    private List<List<Integer>> edges;
    private int[] visited;
    boolean valid = true;

    /**
     * DFS 的拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //从所有的节点开始遍历整个有向图
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        //获取到该节点可以到达的所有节点
        for (int v : edges.get(i)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }



    /**
     * BFS 根据入度判断
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //每条边
        List<List<Integer>> edges = new ArrayList<>();
        //每个节点的入度数
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        //挑选入度为0的结点入队
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
