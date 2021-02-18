package com.study.LeetCode501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * @author jianghui
 * @date 2021-02-18 09:55
 */
public class LeetCode590 {
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
    public List<Integer> postorder(Node root) {
        postOrder(root);
        return ans;
    }
    private void postOrder(Node root){
        if (root == null){
            return;
        }
        for (Node node : root.children){
            postorder(node);
        }
        ans.add(root.val);
    }
}
