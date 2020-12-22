package com.study.leetcode201_300;

/**
 * 反转链表  相关题92 83 86 328 2 445
 *
 * @author jianghui
 * @date 2020-09-16  10:48
 **/
public class LeetCode206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
