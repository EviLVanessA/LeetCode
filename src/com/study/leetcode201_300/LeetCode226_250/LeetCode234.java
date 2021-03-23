package com.study.leetcode201_300.LeetCode226_250;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * @author jianghui
 * @date 2021-03-01 21:04
 */
public class LeetCode234 {
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

    public boolean isPalindrome(ListNode head) {
        ListNode pre = head;
        List<Integer> list = new ArrayList<>();
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
