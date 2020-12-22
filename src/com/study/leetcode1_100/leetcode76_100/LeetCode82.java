package com.study.leetcode1_100.leetcode76_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2020-12-22 10:09
 */
public class LeetCode82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            int key = pre.next.val;
            map.put(key, map.getOrDefault(key, 0) + 1);
            pre = pre.next;
        }
        pre = dummyHead;
        while (pre.next != null) {
            if (map.getOrDefault(pre.next.val, 0) >= 2) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nowHead = new ListNode(0);
        //是否重复
        boolean repeat = false;
        ListNode temp = nowHead;
        int beforeVal = head.val;
        head = head.next;

        while (head != null) {
            //出现重复
            if (head.val == beforeVal) {
                repeat = true;
            } else {
                //判断是否重复
                if (!repeat) {
                    temp.next = new ListNode(beforeVal);
                    temp = temp.next;
                }
                //重置
                repeat = false;
                //更新
                beforeVal = head.val;
            }
            head = head.next;
        }

        if (!repeat) {
            temp.next = new ListNode(beforeVal);
        }
        return nowHead.next;
    }
}
