package com.study.leetcode101_200.leetcode101_125;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-28 15:57
 */
public class LeetCode109 {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return createBST(head, null);
    }

    private TreeNode createBST(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = createBST(left, mid);
        root.right = createBST(mid.next, right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    ListNode globalHead;

    private TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return createBST(0, length - 1);
    }

    private int getLength(ListNode head) {
        int num = 0;
        while (head != null) {
            head = head.next;
            ++num;
        }
        return num;
    }

    private TreeNode createBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        //模拟中序遍历
        root.left = createBST(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = createBST(mid + 1, right);
        return root;
    }

}
