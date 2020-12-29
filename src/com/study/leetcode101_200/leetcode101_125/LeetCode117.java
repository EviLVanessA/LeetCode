package com.study.leetcode101_200.leetcode101_125;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2020-12-29 17:13
 */
public class LeetCode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next){
                if (p.left != null){
                    handle(p.left);
                }
                if (p.right != null){
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    private void handle(Node p){
        if (last != null){
            last.next = p;
        }
        if (nextStart == null){
            nextStart = p;
        }
        last = p;
    }
}
