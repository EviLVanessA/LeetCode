package com.study.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组
 *
 * @author jianghui
 * @date 2021-02-01 15:18
 */
public class Interview0403 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }
        List<ListNode> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            ListNode curNode = new ListNode(0);
            ListNode pre = curNode;
            for (int i = 0; i < curSize; i++) {
                TreeNode curTreeNode = queue.poll();
                if (curTreeNode.left != null) {
                    queue.offer(curTreeNode.left);
                }
                if (curTreeNode.right != null) {
                    queue.offer(curTreeNode.right);
                }
                if (i == 0) {
                    pre.val = curTreeNode.val;
                } else {
                    pre.next = new ListNode(curTreeNode.val);
                    pre = pre.next;
                }
            }
            ans.add(curNode);
        }
        ListNode[] res = new ListNode[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
