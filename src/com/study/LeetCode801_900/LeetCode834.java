package com.study.LeetCode801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 *
 * @author jianghui
 * @date 2021-02-22 09:51
 */
public class LeetCode834 {
    int[] ans;
    //sz[u]表示以u为根节点的子树的节点数量
    int[] sz;
    //dp[u]表示以u为根节点的子树，它的所有子节点到u的距离之和
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int root, int father) {
        sz[root] = 1;
        dp[root] = 0;
        for (int v : graph.get(root)) {
            if (v == father) {
                continue;
            }
            dfs(v, root);
            dp[root] += dp[v] + sz[v];
            sz[root] += sz[v];
        }
    }

    private void dfs2(int root, int father) {
        ans[root] = dp[root];
        for (int v : graph.get(root)) {
            if (v == father) {
                continue;
            }
            int pu = dp[root], pv = dp[v];
            int su = sz[root], sv = sz[v];
            //v变成u的父节点 所以u的子树路径要减去v贡献的部分
            dp[root] -= dp[v] + sz[v];
            //v变成u的父节点 所以u的子节点要减去v贡献的部分
            sz[root] -= sz[v];
            //v变成u的父节点 所以V的子数路径要加上u贡献的部分
            dp[v] += dp[root] + sz[root];
            //v变成u的父节点 所以V的子节点要加上v贡献的部分
            sz[v] += sz[root];

            dfs2(v, root);
            //对数据进行还原
            dp[root] = pu;
            dp[v] = pv;
            sz[root] = su;
            sz[v] = sv;
        }
    }
}
