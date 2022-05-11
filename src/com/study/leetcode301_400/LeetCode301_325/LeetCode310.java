package com.study.leetcode301_400.LeetCode301_325;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/10
 */
public class LeetCode310 {
    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {1, 2}, {1, 3}};
        for (Integer i : new LeetCode310().findMinHeightTrees1(4, arr)) {
            System.out.print(i + " ");
        }
    }

    //暴力 超时
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Set<Integer>> newEdge = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int[] edge : edges) {
            if (newEdge.containsKey(edge[0])) {
                newEdge.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                newEdge.put(edge[0], set);
            }

            if (newEdge.containsKey(edge[1])) {
                newEdge.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                newEdge.put(edge[1], set);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            int curHigh = dfs1(visited, newEdge, i, n);
            result.put(i, curHigh);
            min = Math.min(curHigh, min);
        }
        for (Integer key : result.keySet()) {
            if (result.get(key) == min) {
                ans.add(key);
            }
        }
        return ans;
    }

    private int dfs1(Set<Integer> visited, Map<Integer, Set<Integer>> newEdge, int i, int n) {
        if (visited.size() == n) {
            return 0;
        }
        Set<Integer> nodes = newEdge.get(i);
        int maxHigh = 0;
        for (Integer node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            int curHigh = 1 + dfs1(visited, newEdge, node, n);
            maxHigh = Math.max(curHigh, maxHigh);
        }
        return maxHigh;
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        //找到与0 最远的节点x
        int x = findLongestNode(0, parent, adj);
        //找到与节点x最远的y
        int y = findLongestNode(x, parent, adj);
        //求出节点x到y的路径
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    private int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[u] = 0;
        dfs(u, dist, parent, adj);
        int maxDist = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                node = i;
            }
        }
        return node;
    }

    private void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
        for (Integer v : adj[u]) {
            if (dist[v] < 0) {
                dist[v] = dist[u] + 1;
                parent[v] = u;
                dfs(v, dist, parent, adj);
            }
        }
    }
}
