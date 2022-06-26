package com.study.demo;

/**
 * @author jianghui
 * @date 2022-06-19 21:03
 */
public class SegmentTree2 {

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
        //懒标记 2表示不需要操作
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
            root.value += (root.right - root.left + 1) * value;
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

    public SegmentTree2() {
        root = new Node(1, 8);
    }


    public int query(int left, int right) {
        return query(root, left, right);
    }

    public void update(int left, int right, int value) {
        update(root, left, right, value);
    }

    public static void main(String[] args) {
        SegmentTree2 segmentTree2 = new SegmentTree2();
//        segmentTree2.addRange(10, 20);
//        segmentTree2.removeRange(14, 16);
//        System.out.println(segmentTree2.queryRange(10, 14));
//        System.out.println(segmentTree2.queryRange(13, 15));
//        System.out.println(segmentTree2.queryRange(16, 20));
        System.out.println(segmentTree2.query(3, 5));
        segmentTree2.update(3, 5, 2);
        System.out.println(segmentTree2.query(3, 5));
        segmentTree2.update(3, 5, 1);
        System.out.println(segmentTree2.query(3, 5));
    }
}