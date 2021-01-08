package com.study.leetcode101_200.leetcode126_150;

import javafx.beans.value.ObservableNumberValue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jianghui
 * @date 2021-01-07 13:48
 */
public class LeetCode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> pos = new HashSet<>();
        while (head != null) {
            if (!pos.contains(head)) {
                pos.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 使用双指针
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (fast == slow){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
