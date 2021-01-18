package com.study.leetcode201_300.LeetCode226_250;

/**
 * 删除链表中的节点(无链表头)
 * @author jianghui
 * @date 2020-09-16  12:38
 **/
public class LeetCode237 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
