package com.study.competition.competition305;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-08-07 10:34
 */
public class LeetCode6139 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        Map<Integer, List<Integer>> edge = new HashMap<>();
        for (int[] ints : edges) {
            edge.putIfAbsent(ints[0], new ArrayList<>());
            edge.putIfAbsent(ints[1], new ArrayList<>());
            edge.get(ints[0]).add(ints[1]);
            edge.get(ints[1]).add(ints[0]);
        }
        int ans = Integer.MIN_VALUE;
        int[] visited = new int[n];
        ans = Math.max(ans, dfs(set, edge, 0, visited));
        return ans;
    }

    private int dfs(Set<Integer> set, Map<Integer, List<Integer>> edge, int i, int[] visited) {
        int ans = 1;
        List<Integer> list = edge.get(i);
        visited[i] = 1;
        if (list != null) {
            for (Integer integer : list) {
                if (!set.contains(integer) && visited[integer] == 0) {
                    ans += dfs(set, edge, integer, visited);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode6139 leetCode6139 = new LeetCode6139();
        System.out.println(leetCode6139.reachableNodes(10, new int[][]{{8, 2}, {2, 5}, {5, 0}, {2, 7}, {1, 7}, {3, 8}, {0, 4}, {3, 9}, {1, 6}}, new int[]{9, 8, 4, 5, 3, 1}));
    }
}
