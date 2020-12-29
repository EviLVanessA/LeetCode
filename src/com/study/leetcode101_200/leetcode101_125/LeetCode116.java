package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2020-12-29 16:40
 */
public class LeetCode116 {
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

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root;
        while (left.left != null) {
            Node head = left;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            left = left.left;
        }
        return root;
    }
}
