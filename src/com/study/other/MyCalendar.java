package com.study.other;

import com.study.demo.SegmentTree2;

/**
 * @author jianghui
 * @date 2022-07-04 21:35
 */
public class MyCalendar {
    /**
     * 线段树的结点
     */
    static class Node {
        //左范围
        private int left;
        //右范围
        private int right;
        //区间和
        private int value;
        //懒标记
        private int lazy;
        //左子树和右子树
        Node leftChild, rightChild;

        public Node(int leftX, int rightX) {
            this.left = leftX;
            this.right = rightX;
        }
    }

    private Node root;


    /**
     * 区间更新
     *
     * @param root  树的根
     * @param left  左边界
     * @param right 有边界
     * @param value 更新值
     */
    public void update(Node root, int left, int right, int value) {
        //不在范围内 直接返回
        if (root.left > right || root.right < left) {
            return;
        }
        //修改的区间包含当前结点
        if (root.left >= left && root.right <= right) {
            root.lazy = value;
            root.value = (root.right - root.left + 1) * value;
        } else {
            //动态开点
            lazyCreate(root);
            //下传lazy
            pushDown(root);
            //更新左子树
            update(root.leftChild, left, right, value);
            //更新右子树
            update(root.rightChild, left, right, value);
            //上传结果
            pushUp(root);
        }
    }

    public int query(Node root, int left, int right) {
        if (left <= root.left && root.right <= right) {
            return root.value;
        }
        lazyCreate(root);
        pushDown(root);
        int mid = root.left + (root.right - root.left) / 2;
        if (right <= mid) {
            return query(root.leftChild, left, right);
        } else if (left > mid) {
            return query(root.rightChild, left, right);
        } else {
            return query(root.leftChild, left, mid) + query(root.rightChild, mid + 1, right);
        }
    }

    /**
     * 创建左右子树
     *
     * @param root
     */
    public void lazyCreate(Node root) {
        if (root.leftChild == null) {
            root.leftChild = new Node(root.left, root.left + (root.right - root.left) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.left + (root.right - root.left) / 2 + 1, root.right);
        }
    }

    /**
     * 下传lazy
     *
     * @param root
     */
    public void pushDown(Node root) {
        if (root.lazy == 0) {
            return;
        }
        int value = root.lazy;
        root.leftChild.lazy = value;
        root.rightChild.lazy = value;
        root.leftChild.value += (root.leftChild.right - root.leftChild.left + 1) * value;
        root.rightChild.value += (root.rightChild.right - root.rightChild.left + 1) * value;
        root.lazy = 0;
    }

    /**
     * 上传结果
     *
     * @param root
     */
    public void pushUp(Node root) {
        root.value = root.leftChild.value + root.rightChild.value;
    }

    public MyCalendar() {
        root = new Node(1, (int) 1e9);
    }

    public boolean book(int start, int end) {
        int query = query(root, start, end - 1);
        if (query > 0) {
            return false;
        }
        update(root, start, end - 1, 1);
        return true;
    }
}
