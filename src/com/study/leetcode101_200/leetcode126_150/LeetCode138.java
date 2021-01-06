package com.study.leetcode101_200.leetcode126_150;

import java.util.HashMap;

/**
 * @author jianghui
 * @date 2021-01-06 18:31
 */
public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node,Node> visited = new HashMap<>();
    /**
     * DFS
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (visited.containsKey(head)){
            return visited.get(head);
        }
        Node node = new Node(head.val);
        visited.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
