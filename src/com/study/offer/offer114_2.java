package com.study.offer;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/31
 */
public class offer114_2 {

    /**
     * 是否存在不合法
     */
    private boolean valid = true;

    /**
     * 存放每个点的入度
     */
    private int[] inDegrees = new int[26];


    public String alienOrder(String[] words) {
        //构建图
        Map<Character, List<Character>> edges = buildGraph(words);
        //在构建图中存在不合法情况
        if (!valid) {
            return "";
        }
        return bfs(edges);
    }

    /**
     * 构建图
     *
     * @param words 单词列表
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
                    //添加边
                    edges.get(pre.charAt(j)).add(cur.charAt(j));
                    //入度+1
                    inDegrees[cur.charAt(j) - 'a']++;
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
     * 广度优先遍历
     *
     * @param edges 当前图
     * @return 字符串
     */
    private String bfs(Map<Character, List<Character>> edges) {
        StringBuilder ans = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character point : edges.keySet()) {
            //结果集入度为0
            if (inDegrees[point - 'a'] == 0) {
                queue.offer(point);
            }
        }
        //队列中是否存在入度为0的点
        while (!queue.isEmpty()) {
            char curPoint = queue.poll();
            ans.append(curPoint);
            List<Character> nextPoints = edges.get(curPoint);
            for (Character nextPoint : nextPoints) {
                //入度-1
                inDegrees[nextPoint - 'a']--;
                //判断是否入度为0 为0加入队列
                if (inDegrees[nextPoint - 'a'] == 0) {
                    queue.offer(nextPoint);
                }
            }
        }
        //是否所有的点都加入了结果集，如果不是则存在环
        return ans.length() == edges.size() ? ans.toString() : "";
    }
}
