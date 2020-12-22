package com.study.leetcode1_100.leetcode1_25;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 相关题61 143 234
 * @author jianghui
 * @date 2020-09-16  12:44
 **/
public class LeetCode19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        while (q.next != null){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }
}
