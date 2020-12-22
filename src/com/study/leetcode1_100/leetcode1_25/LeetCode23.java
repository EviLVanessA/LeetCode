package com.study.leetcode1_100.leetcode1_25;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author jianghui
 * @date 2020-09-27  9:08
 **/
public class LeetCode23 {
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


    /**
     * 暴力算法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwo(ans, list);
        }
        return ans;
    }
    private ListNode mergeTwo(ListNode ans, ListNode list){
        if (ans == null || list == null) {
            return ans != null ? ans : list;
        }
        ListNode dummyHead = new ListNode(0);

        ListNode ansNode = dummyHead;
        ListNode pNode = ans;
        ListNode qNode = list;
        while (pNode != null && qNode != null){
            if (pNode.val <= qNode.val){
                ansNode.next = pNode;
                pNode = pNode.next;
            }else {
                ansNode.next = qNode;
                qNode = qNode.next;
            }
            ansNode = ansNode.next;
        }
        ansNode.next = (pNode != null ? pNode : qNode);
        return dummyHead.next;
    }


    class Status implements Comparable<Status>{
        private int val;
        private ListNode node;

        Status(int val, ListNode listNode){
            this.val = val;
            this.node = listNode;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
    /**
     * 使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {

        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists){
            if (node != null){
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.node;
            tail = tail.next;
            if (f.node.next != null){
                queue.offer(new Status(f.node.val,f.node.next));
            }
        }
        return dummyHead.next;
    }

    /**
     * 优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        for (ListNode node : lists){
            queue.offer(node);
        }

        while (!queue.isEmpty()){
            ListNode f = queue.poll();
            tail.next = f;
            tail = tail.next;
            if (f.next != null){
                queue.offer(f.next);
            }
        }
        return dummyHead.next;

    }

}
