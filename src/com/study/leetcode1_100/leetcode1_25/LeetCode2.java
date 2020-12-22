package com.study.leetcode1_100.leetcode1_25;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 
 * 逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author jianghui
 * @date 2020-09-21  17:24
 **/
public class LeetCode2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode p = sum;
        int up = 0;
        while (l1 != null && l2 != null){
            int num = l1.val + l2.val + up;
            if (num > 9){
                up = 1 ;
            }else {
                up = 0;
            }
            num = num % 10;
            ListNode node = new ListNode(num);
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            if (up == 1){
                l1.val++;
                if (l1.val > 9){
                    l1.val = 0;
                }else {
                    up = 0;
                }
            }
            ListNode node = new ListNode(l1.val);
            p.next = node;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null){
            if (up == 1){
                l2.val++;
                if (l2.val > 9){
                    l2.val = 0;
                }else {
                    up = 0;
                }
            }
            ListNode node = new ListNode(l2.val);
            p.next = node;
            p = p.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && up == 1){
            ListNode node = new ListNode(1);
            p.next = node;
            p = p.next;
            p.next = null;
        }
        return sum.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean flag = false;
        int v1, v2, sum;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        ListNode newNode;
        while(true) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + (flag ? 1 : 0);
            if(l1 == null && l2 == null && sum == 0) {
                break;
            }
            newNode = new ListNode(sum % 10);
            flag = sum >= 10;
            res.next = newNode;
            res = res.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
