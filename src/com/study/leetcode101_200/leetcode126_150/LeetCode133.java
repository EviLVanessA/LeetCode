package com.study.leetcode101_200.leetcode126_150;

import java.util.*;

/**
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 *
 * @author jianghui
 * @date 2021-01-06 14:28
 */
public class LeetCode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    private Map<Node, Node> visited = new HashMap<>();

    /**
     * 采用深度优先遍历
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val,new ArrayList<>());
        visited.put(node,cloneNode);
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    /**
     * 广度优先遍历 BFS
     * @param node
     * @return
     */
    public Node cloneGraph2(Node node) {
        if (node == null){
            return null;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));

        while (!queue.isEmpty()){
            Node n = queue.remove();
            for (Node node1 : n.neighbors){
                //进行广度优先遍历
                if (!visited.containsKey(node1)){
                    visited.put(node1,new Node(node1.val,new ArrayList<>()));
                    queue.add(node1);
                }
                visited.get(n).neighbors.add(visited.get(node1));
            }
        }
        return visited.get(node);
    }

}
