package com.study.leetcode401_500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2021-02-04 15:30
 */
public class LeetCode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int curSize = queue.size();
            List<Integer> curAns = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                Node curNode = queue.poll();
                for (Node node : curNode.children){
                    queue.offer(node);
                }
                curAns.add(curNode.val);
            }
            ans.add(curAns);
        }
        return ans;
    }
}
