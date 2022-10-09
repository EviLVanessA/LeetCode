//package com.study.LeetCode801_900;
//
///**
// * @author jianghui
// * @date 2022-09-15 21:07
// */
//public class LeetCode850 {
//    public static void main(String[] args) {
//        SegmentTree segmentTree = new SegmentTree();
//        segmentTree.update(1, 5, 1);
//        segmentTree.update(1, 4, -1);
//        System.out.println(segmentTree.query());
//    }
//}
//
//class SegmentTree {
//
//    public SegmentTree() {
//        root = new Node(0, 27);
//    }
//
//    /**
//     * 线段树的结点
//     */
//    static class Node {
//        //左范围
//        private int left;
//        //右范围
//        private int right;
//        //覆盖的长度
//        private int coverLen;
//        //是否被完全覆盖 0表示没有 大于1表示完全覆盖
//        private int cover;
//        //左子树和右子树
//        Node leftChild, rightChild;
//
//        public Node(int left, int right) {
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    private Node root;
//
//
//    /**
//     * 区间更新
//     *
//     * @param root  树的根
//     * @param left  左边界
//     * @param right 有边界
//     * @param value 更新值
//     */
//    public void update(Node root, int left, int right, int value) {
//        //不在范围内 直接返回
//        if (root.left > right || root.right < left) {
//            return;
//        }
//        //动态开点
//        createNode(root);
//        //修改的区间包含当前结点
//        if (root.left >= left && root.right <= right) {
//            root.cover += value;
//        } else {
//            //更新左子树
//            update(root.leftChild, left, right, value);
//            //更新右子树
//            update(root.rightChild, left, right, value);
//        }
//        pushUp(root);
//    }
//
//    /**
//     * 创建左右子树
//     *
//     * @param root
//     */
//    public void createNode(Node root) {
//        if (root.leftChild == null) {
//            root.leftChild = new Node(root.left, root.left + (root.right - root.left) / 2);
//        }
//        if (root.rightChild == null) {
//            root.rightChild = new Node(root.left + (root.right - root.left) / 2 + 1, root.right);
//        }
//    }
//
//    /**
//     * 上传结果
//     *
//     * @param root
//     */
//    public void pushUp(Node root) {
//        if (root.cover > 0) {
//            root.coverLen = root.right - root.left + 1;
//        } else if (root.left != root.right) {
//            root.coverLen = root.leftChild.coverLen + root.rightChild.coverLen;
//        } else {
//            root.coverLen = 0;
//        }
//    }
//
//    public int query() {
//        return root.coverLen;
//    }
//
//    public void update(int left, int right, int value) {
//        update(root, left, right, value);
//    }
//
//
//}