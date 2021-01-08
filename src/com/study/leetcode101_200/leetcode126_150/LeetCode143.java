package com.study.leetcode101_200.leetcode126_150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author jianghui
 * @date 2021-01-07 15:40
 */
public class LeetCode143 {
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

    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                break;
            }
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        ListNode pre = head;
        while (!stack.isEmpty()){
            ListNode top = stack.pop();
            top.next = pre.next;
            pre.next = top;
            pre = pre.next.next;
        }
        pre.next = null;
    }
}
