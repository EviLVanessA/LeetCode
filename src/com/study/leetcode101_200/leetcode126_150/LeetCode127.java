package com.study.leetcode101_200.leetcode126_150;

import java.util.*;

/**
 * @author jianghui
 * @date 2021-01-04 10:15
 */
public class LeetCode127 {

    /**
     * 广度优先遍历+优化建图
     */
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        dis[beginId] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int i : edge.get(x)) {
                if (dis[i] == Integer.MAX_VALUE) {
                    dis[i] = dis[x] + 1;
                    queue.offer(i);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        //添加单词到Map中
        addWord(word);
        //获取该单词的编号
        int id1 = wordId.get(word);
        char[] chars = word.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String newWord = new String(chars);
            //将新单词加入到Map中 创建的虚拟节点 每个字符分别都用*替换后加入到Map中
            addWord(newWord);
            int id2 = wordId.get(newWord);
            //将两个边 建立联系
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            chars[i] = temp;
        }
    }

    private void addWord(String word) {
        //将单词加入Map中 为每个单位赋予一个编号
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            //给每个边建立一个与之相连的集合类
            edge.add(new ArrayList<>());
        }
    }

    /**
     * 双向广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }

        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queBegin = new LinkedList<Integer>();
        queBegin.offer(beginId);

        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queEnd = new LinkedList<Integer>();
        queEnd.offer(endId);

        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; ++i) {
                int nodeBegin = queBegin.poll();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; ++i) {
                int nodeEnd = queEnd.poll();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }


}
