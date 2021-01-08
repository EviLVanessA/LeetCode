package com.study.leetcode101_200.leetcode126_150;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
    public Node copyRandomList2(Node head) {
        if (head == null){
            return null;
        }
        Node pre = head;
        while (pre != null){
            Node node = new Node(pre.val);
            node.next = pre.next;
            pre.next = node;
            pre = node.next;
        }
        pre = head;
        while (pre != null){
            pre.next.random = (pre.random != null) ? pre.random.next : null;
            pre = pre.next.next;
        }
        Node ptrOldList = head;
        Node ptrNewList = head.next;
        Node headOld = head.next;
        while (ptrOldList != null) {
            ptrOldList.next = ptrOldList.next.next;
            ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }
        return headOld;
    }
}
