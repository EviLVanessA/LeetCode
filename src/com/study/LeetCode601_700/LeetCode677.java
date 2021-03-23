package com.study.LeetCode601_700;

import java.util.TreeMap;

/**
 * @author jianghui
 * @date 2021-03-15 15:42
 */
public class LeetCode677 {
    class MapSum {
        /**
         * 定义内部节点 存储当前的value和他所连接的node，树的每条边代表了每一个字母
         */
        private class Node {
            private int value;
            private TreeMap<Character, Node> next;

            public Node(int value) {
                this.value = value;
                next = new TreeMap<>();
            }

            public Node() {
                this(0);
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            char[] chars = key.toCharArray();
            for (char ch : chars) {
                //判断当前节点是否包含这条边 包含直接跳过 不包含则进行put
                if (!cur.next.containsKey(ch)) {
                    cur.next.put(ch, new Node());
                }
                cur = cur.next.get(ch);
            }
            //给单词的最后一个节点赋值value
            cur.value = val;
        }

        public int sum(String prefix) {
            Node cur = root;
            char[] chars = prefix.toCharArray();
            for (char ch : chars) {
                //判断当前节点是否包含这条边 包含直接跳过 不包含则直接返回
                if (cur.next.get(ch) == null) {
                    return 0;
                }
                cur = cur.next.get(ch);
            }
            //递归进行sum求和
            return sum(cur);
        }

        private int sum(Node node) {
            //若当前node没有子节点 直接进行返回
            if (node.next.size() == 0){
                return node.value;
            }
            int ans = node.value;
            //遍历所有的子节点
            for (char c : node.next.keySet()) {
                //子节点递归调用sum进行求和
                ans += sum(node.next.get(c));
            }
            return ans;
        }
    }
}
