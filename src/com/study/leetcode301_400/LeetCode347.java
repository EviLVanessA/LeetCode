package com.study.leetcode301_400;

import java.util.*;

/**
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 相关试题 23
 * @author jianghui
 * @date 2020-09-17  11:05
 **/
public class LeetCode347 {
    public static void main(String[] args) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.fre - o2.fre ;
            }
        });

    }
    public class Node{
        private int num;
        private int fre;
        public Node(int num,int fre){
            this.num = num;
            this.fre = fre;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frep = new HashMap<>();
        //统计出现的频率
        for (int num : nums) {
            frep.put(num, frep.containsKey(num) ? frep.get(num) + 1 : 1);
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.fre - o2.fre ;
            }
        });
        for (Integer num : frep.keySet()){
            int fre = frep.get(num);
            if (queue.size() == k){
                if (queue.peek().fre < fre){
                    queue.remove();
                    queue.offer(new Node(num,fre));
                }
            }else {
                queue.offer(new Node(num,fre));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove().num;
        }
        return res;
    }
}
