package com.study.leetcode1_100.leetcode1_25;

/**
 * 两两交换链表中的节点 25 147 148(归并)
 * @author jianghui
 * @date 2020-09-16  11:34
 **/
public class LeetCode24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next !=null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummyHead.next;
    }
}
