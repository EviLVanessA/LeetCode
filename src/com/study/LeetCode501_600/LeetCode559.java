package com.study.LeetCode501_600;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author jianghui
 * @date 2021-02-10 08:42
 */
public class LeetCode559 {
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

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        return dfs(root) + 1;
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> nodes = root.children;
        int max = 0;
        for (Node node : nodes) {
            max = Math.max(dfs(node) + 1, max);
        }
        return max;
    }

}
