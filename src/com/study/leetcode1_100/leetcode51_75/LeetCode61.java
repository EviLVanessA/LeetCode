package com.study.leetcode1_100.leetcode51_75;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author jianghui
 * @date 2020-12-16 14:34
 */
public class LeetCode61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode tail = head;
        ListNode target = head;
        int sum = 1;
        while (tail.next != null) {
            sum++;
            tail = tail.next;
        }
        k = k % sum;
        for (int i = 0; i < sum - k; i++) {
            target = target.next;
        }
        tail.next = head;
        head = target.next;
        target.next = null;
        return head;
    }
}
