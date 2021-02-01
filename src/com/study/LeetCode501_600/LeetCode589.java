package com.study.LeetCode501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * @author jianghui
 * @date 2021-02-01 15:40
 */
public class LeetCode589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }


    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return ans;
    }
    private void preOrder(Node root){
        if (root == null){
            return;
        }
        ans.add(root.val);
        for (Node node : root.children){
            preOrder(node);
        }
    }
}
