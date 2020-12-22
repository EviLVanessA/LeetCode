package com.study.leetcode1_100.leetcode76_100;

/**
 * @author jianghui
 * @date 2020-12-22 10:26
 */
public class LeetCode83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next !=null){
            if (pre.next.val == pre.next.next.val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
