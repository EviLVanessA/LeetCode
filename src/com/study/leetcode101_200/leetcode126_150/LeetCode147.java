package com.study.leetcode101_200.leetcode126_150;

/**
 * @author jianghui
 * @date 2021-01-07 17:15
 */
public class LeetCode147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode oldNext = head.next;
        head.next = null;
        insert(dummyHead,oldNext);
        return dummyHead.next;
    }

    private void insert(ListNode dummyHead, ListNode oldHead) {
        if (oldHead == null){
            return;
        }
        ListNode node = dummyHead.next;
        ListNode pre = dummyHead;
        while (node != null && node.val < oldHead.val){
            pre = pre.next;
            node = node.next;
        }
        ListNode oldNext;
        oldNext = oldHead.next;
        if (node == null){
            pre.next = oldHead;
            pre = pre.next;
            pre.next = null;
        }else {
            oldHead.next = pre.next;
            pre.next = oldHead;
        }
        insert(dummyHead,oldNext);
    }
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;

        }
        return dummyHead.next;
    }

}
