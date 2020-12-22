package com.study.leetcode1_100.leetcode76_100;

/**
 * @author jianghui
 * @date 2020-12-22 16:08
 */
public class LeetCode86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode pre = left;
        ListNode right = new ListNode(0);
        ListNode after = right;
        while (head != null){
            if (head.val < x){
                pre.next = head;
                pre = pre.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        pre.next = right.next;
        return left.next;
    }
}
