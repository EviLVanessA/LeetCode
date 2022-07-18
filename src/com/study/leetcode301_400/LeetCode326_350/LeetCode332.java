package com.study.leetcode301_400.LeetCode326_350;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/7/14
 */
public class LeetCode332 {
    Map<String, PriorityQueue<String>> edge = new HashMap<>();
    List<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            edge.putIfAbsent(from, new PriorityQueue<>());
            edge.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String from) {
        while (edge.containsKey(from) && edge.get(from).size() > 0) {
            String to = edge.get(from).poll();
            dfs(to);
        }
        ans.add(from);
    }
}
