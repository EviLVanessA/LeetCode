package com.study.offer;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/31
 */
public class offer114 {

    /**
     * 是否存在不合法
     */
    private boolean valid = true;
    /**
     * 存放字典序结果
     */
    private StringBuilder ans;

    public String alienOrder(String[] words) {
        //是否已经遍历 0表示未遍历 1表示遍历中 2表示已完成遍历
        Map<Character, Integer> visited = new HashMap<>();
        //构建图
        Map<Character, List<Character>> edges = buildGraph(words);
        //在构建图中存在不合法情况
        if (!valid) {
            return "";
        }
        ans = new StringBuilder();
        //对所有的点做DFS遍历
        for (Character point : edges.keySet()) {
            if (!visited.containsKey(point)) {
                dfs(point, visited, edges);
            }
        }
        return valid ? ans.toString() : "";
    }

    /**
     * 构建图
     *
     * @param words 单词列表
     * @return 边的集合
     */
    private Map<Character, List<Character>> buildGraph(String[] words) {
        Map<Character, List<Character>> edges = new HashMap<>();
        //存放所有的点
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                edges.putIfAbsent(word.charAt(j), new ArrayList<>());
            }
        }
        //存放所有的边
        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String cur = words[i + 1];
            int minLength = Math.min(pre.length(), cur.length());
            int j = 0;
            while (j < minLength) {
                if (pre.charAt(j) != cur.charAt(j)) {
                    edges.get(pre.charAt(j)).add(cur.charAt(j));
                    break;
                }
                j++;
            }
            //存在不合法的情况 前一个字符串长度大于当前字符串长度 但前minLength均相等
            if (j == minLength && pre.length() > cur.length()) {
                valid = false;
            }
        }
        return edges;
    }

    /**
     * 深度优先遍历
     *
     * @param point   当前点
     * @param visited 是否遍历过当前点
     * @param edges   边的集合
     */
    public void dfs(char point, Map<Character, Integer> visited, Map<Character, List<Character>> edges) {
        //设置当前点为遍历中
        visited.put(point, 1);
        //拿到当前点  能到达的所有点
        List<Character> points = edges.get(point);
        for (Character nextPoint : points) {
            if (!visited.containsKey(nextPoint)) {
                dfs(nextPoint, visited, edges);
                //此时存在环 不合法
                if (!valid) {
                    return;
                }
            } else if (visited.get(nextPoint) == 1) {
                //当前DFS路径有环
                valid = false;
                return;
            }
        }
        //设置当前点为已遍历
        visited.put(point, 2);
        //加入字典序，每次都加入第一个，深度优先遍历的终点是叶子节点
        ans.insert(0, point);
    }
}
