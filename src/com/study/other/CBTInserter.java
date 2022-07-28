package com.study.other;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2021-03-02 18:23
 */
public class CBTInserter {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode root;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new ArrayDeque<>();
        //采用层序遍历 找到没有叶子结点的结点存放到队列中
        //只有这些结点才可以添加结点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //顺序存储没有叶子结点的结点
            if (node.left == null || node.right == null) {
                deque.offer(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        //该节点如果一个叶子结点都没有 插入左节点
        if (node.left == null) {
            node.left = deque.peekLast();
        } else {
            //有左节点、插入右节点并删除该结点
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
