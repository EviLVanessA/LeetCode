package com.study.leetcode101_200.leetcode126_150;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author jianghui
 * @date 2020-12-31 10:26
 */
public class LeetCode126 {
    /**
     * 单词到id的映射
     */
    private Map<String, Integer> wordId = new HashMap<>();
    /**
     * id到单词的映射
     */
    private List<String> idWord = new ArrayList<>();
    /**
     * 图的边
     */
    private List<Integer>[] edge;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        //将所有的单词加入到Map中 并分配ID
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        //如果不包含结束的单词
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        //将开始的单词加入到Map中
        if (!wordList.contains(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        //初始化边
        edge = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edge[i] = new ArrayList<>();
        }
        //添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edge[i].add(j);
                    edge[j].add(i);
                }
            }
        }
        //目的地
        int dest = wordId.get(endWord);
        List<List<String>> ans = new ArrayList<>();
        //到每个点的代价
        int[] cost = new int[id];
        //将每个值设置为无穷大
        Arrays.fill(cost, Integer.MAX_VALUE);
        //将起点加入队列 并设置其cost为0
        Queue<ArrayList<Integer>> queue = new ArrayDeque<>();
        ArrayList<Integer> tempBegin = new ArrayList<>();
        //存放的是ID
        tempBegin.add(wordId.get(beginWord));
        queue.add(tempBegin);
        cost[wordId.get(beginWord)] = 0;
        //开始广度优先遍历
        while (!queue.isEmpty()) {
            ArrayList<Integer> now = queue.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                //若该点为终点则将其存入答案中
                ArrayList<String> temp = new ArrayList<>();
                for (int index : now) {
                    temp.add(idWord.get(index));
                }
                ans.add(temp);
            }else {
                //该点不为终点 继续搜索
                for (int i = 0; i < edge[last].size(); i++) {
                    int to = edge[last].get(i);
                    if (cost[last] + 1 <= cost[to]){
                        cost[to] = cost[last] + 1;
                        //把to加进队列
                        ArrayList<Integer> temp = new ArrayList<>(now);
                        temp.add(to);
                        queue.add(temp);
                    }
                }
            }
        }
        return ans;
    }

    private boolean transformCheck(String str1, String str2) {
        int difference = 0;
        for (int i = 0; i < str1.length() && difference < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                difference++;
            }
        }
        return difference == 1;
    }
}
