package com.study.leetcode201_300.LeetCode276_300;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 *
 * (贪心算法不成立，用时想想能不能用)
 * 对问题建模：
 * 整个问题转化为一个图论问题。从0->n，每个数字表示一个节点，
 * 如果两个数字x->y相差一个完全平方数，则连接一条边，得到一个无权图
 * 原问题转化为，求这个无权图中从n->0的最短路径
 *
 * 相关题127 126
 *
 * @author jianghui
 * @date 2020-09-17  10:30
 **/
public class LeetCode279 {
    public static void main(String[] args) {
        boolean[] vi = new boolean[2];
        System.out.println(vi[1]);
    }
    public class Node{
        private int val;//节点的值
        private int step;//所走的路径
        public Node(int val,int step){
            this.val = val;
            this.step = step;
        }
    }
    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();

        boolean[] visit = new boolean[n+1];
        visit[n] = true;
        queue.offer(new Node(n,0));
        while (queue.size() != 0){
            int num = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            for (int i = 1;; i++) {
                int a = num - i*i;
                if (a < 0){
                    break;
                }
                if (a == 0){
                    return step + 1;
                }
                if (!visit[a]){
                    queue.offer(new Node(a,step+1));
                    visit[a] = true;
                }
            }

        }
        return 0;
    }
}
