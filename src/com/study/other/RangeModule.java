package com.study.other;

/**
 * @author jianghui
 * @date 2022-06-19 21:03
 */
public class RangeModule {

    /**
     * 线段树的结点
     */
    static class Node {
        //左范围
        private int leftX;
        //右范围
        private int rightX;
        //区间和
        private int sum;
        //懒标记 2表示不需要操作
        private int lazy;
        //左子树和右子树
        Node leftChild, rightChild;

        public Node(int leftX, int rightX) {
            this.leftX = leftX;
            this.rightX = rightX;
        }
    }

    private Node root;


    /**
     * 区间更新
     *
     * @param root  树的根
     * @param left  左边界
     * @param right 有边界
     * @param value 更新值,删除则相当于置为0
     */
    public void update(Node root, int left, int right, int value) {
        //不在范围内 直接返回
        if (root.leftX > right || root.rightX < left) {
            return;
        }
        //修改的区间包含当前结点
        if (root.leftX >= left && root.rightX <= right) {
            root.lazy = value;
            root.sum = (root.rightX - root.leftX + 1) * value;
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
        if (left <= root.leftX && root.rightX <= right) {
            return root.sum;
        }
        lazyCreate(root);
        pushDown(root);
        int mid = root.leftX + (root.rightX - root.leftX) / 2;
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
            root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.leftX + (root.rightX - root.leftX) / 2 + 1, root.rightX);
        }
    }

    /**
     * 下传lazy
     *
     * @param root
     */
    public void pushDown(Node root) {
        if (root.lazy == 2) {
            return;
        }
        int value = root.lazy;
        root.leftChild.lazy = value;
        root.rightChild.lazy = value;
        root.leftChild.sum = (root.leftChild.rightX - root.leftChild.leftX + 1) * value;
        root.rightChild.sum = (root.rightChild.rightX - root.rightChild.leftX + 1) * value;
        root.lazy = 2;
    }

    /**
     * 上传结果
     *
     * @param root
     */
    public void pushUp(Node root) {
        root.sum = root.leftChild.sum + root.rightChild.sum;
    }

    public RangeModule() {
        root = new Node(0, (int) (1e9));
    }

    public void addRange(int left, int right) {
        update(root, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return (right - left) == query(root, left, right - 1);
    }

    public void removeRange(int left, int right) {
        update(root, left, right - 1, 0);
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
//        rangeModule.addRange(10, 20);
//        rangeModule.removeRange(14, 16);
//        System.out.println(rangeModule.queryRange(10, 14));
//        System.out.println(rangeModule.queryRange(13, 15));
//        System.out.println(rangeModule.queryRange(16, 20));
        rangeModule.addRange(5, 7);
        rangeModule.addRange(6, 9);
        rangeModule.addRange(2, 7);
        rangeModule.removeRange(3, 10);
        rangeModule.removeRange(1, 8);
        rangeModule.removeRange(1, 10);
        System.out.println(rangeModule.queryRange(4, 7));
    }
}