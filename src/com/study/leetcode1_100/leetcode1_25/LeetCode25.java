package com.study.leetcode1_100.leetcode1_25;

import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @author jianghui
 * @date 2020-09-27  9:54
 **/
public class LeetCode25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(4);
        tail = tail.next;
        tail.next = new ListNode(5);
        tail = tail.next;
        tail.next = new ListNode(6);
        tail = tail.next;
        tail.next = null;

        ListNode head1 = new LeetCode25().reverseKGroup(head,4);
        while (head1 != null){
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            int flag = 0;
            ListNode pre = head;
            for (int i = 0; i < k; i++) {
                if (head != null){
                    stack.push(head);
                    head = head.next;
                    flag ++;
                }
            }
            if (flag == k){
                while (!stack.empty()){
                    tail.next = stack.pop();
                    tail = tail.next;
                }
            }else {
                while (pre != null){
                    tail.next = pre;
                    pre = pre.next;
                    tail = tail.next;
                }
            }
        }
        tail.next = null;
        return dummyHead.next;
    }

    /**
     * 空间复杂度为O(1)
     * 时间复杂度O(n)
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0 ;i < k; i++){
                tail = tail.next;
                if (tail == null){
                    return dummyHead.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] reverse = myReserve(head,tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = nex;

            pre = tail;
            head = tail.next;

        }
        return dummyHead.next;
    }
    private ListNode[] myReserve(ListNode head,ListNode tail){

        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
