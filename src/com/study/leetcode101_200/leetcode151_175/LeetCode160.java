package com.study.leetcode101_200.leetcode151_175;

import java.util.*;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author jianghui
 * @date 2021-01-08 15:32
 */
public class LeetCode160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * hash表法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> list = new HashSet<>();
        ListNode pre = headB;
        while (pre != null){
            list.add(pre);
            pre = pre.next;
        }
        pre = headA;
        while (pre != null){
            if (list.contains(pre)){
                return pre;
            }else {
                pre = pre.next;
            }
        }
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }
}
