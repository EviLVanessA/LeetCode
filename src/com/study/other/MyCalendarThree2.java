package com.study.other;

/**
 * @author jianghui
 * @date 2022-06-05 20:53
 */
public class MyCalendarThree2 {

    private Node root;

    public MyCalendarThree2() {
        root = new Node(0, (int) (1e9));
    }

    public int book(int start, int end) {
        update(root, start, end - 1, 1);
        return root.maxValue;
    }

    /**
     * 线段树的结点
     */
    static class Node {
        //左范围
        private int leftX;
        //右范围
        private int rightX;
        //范围内的最大值
        private int maxValue;
        //懒标记
        private int lazy;
        //左子树和右子树
        Node leftChild, rightChild;

        public Node(int leftX, int rightX) {
            this.leftX = leftX;
            this.rightX = rightX;
        }
    }

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
        if (root.leftX > right || root.rightX < left) {
            return;
        }
        //修改的区间包含当前结点
        if (root.leftX >= left && root.rightX <= right) {
            root.maxValue += value;
            root.lazy += value;
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
        if (root.lazy > 0) {
            root.leftChild.maxValue += root.lazy;
            root.leftChild.lazy += root.lazy;
            root.rightChild.maxValue += root.lazy;
            root.rightChild.lazy += root.lazy;
            root.lazy = 0;
        }
    }

    /**
     * 上传结果
     *
     * @param root
     */
    public void pushUp(Node root) {
        root.maxValue = Math.max(root.leftChild.maxValue, root.rightChild.maxValue);
    }


    public static void main(String[] args) {
        MyCalendarThree2 myCalendarThree2 = new MyCalendarThree2();
        System.out.println(myCalendarThree2.book(10, 20));
        System.out.println(myCalendarThree2.book(50, 60));
        System.out.println(myCalendarThree2.book(10, 40));
        System.out.println(myCalendarThree2.book(5, 15));
        System.out.println(myCalendarThree2.book(5, 10));
        System.out.println(myCalendarThree2.book(25, 55));
    }
}
