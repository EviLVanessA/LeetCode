package com.study.leetcode1_100.leetcode1_25;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author jianghui
 * @date 2020-09-25  11:16
 **/
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7,null))));
        ListNode l2 = new ListNode(2,new ListNode(4,null));
        ListNode l3 = mergeTwoLists(l1,l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
    public static class ListNode {
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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设立虚拟头结点
        ListNode dummyHead = new ListNode(0);
        ListNode r = dummyHead;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null){
            if (p.val <= q.val){
                r.next = p;
                r = r.next;
                p = p.next;
            }else {
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }
        if (q!=null){
            r.next = q;
        }
        if (p!=null){
            r.next = p;
        }
        return dummyHead.next;
    }
}
