package com.study.leetcode201_300;

/**
 * 删除链表中等于给定值val的所有节点 82 21
 * @author jianghui
 * @date 2020-09-16  11:18
 **/
public class LeetCode203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
