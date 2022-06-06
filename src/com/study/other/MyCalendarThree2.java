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

    public void update(Node root, int left, int right, int value) {
        if (root.leftX > right || root.rightX < left) {
            return;
        }
        //修改的区间包含在内
        if (root.leftX >= left && root.rightX <= right) {
            root.maxValue += value;
            root.lazy += value;
        } else {
            pushDown(root);
            update(root.leftChild, left, right, value);
            update(root.rightChild, left, right, value);
            pushUp(root);
        }
    }

    public void lazyCreate(Node root) {
        if (root.leftChild == null) {
            root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.leftX + (root.rightX - root.leftX) / 2 + 1, root.rightX);
        }
    }

    public void pushDown(Node root) {
        lazyCreate(root);
        if (root.lazy > 0) {
            root.leftChild.maxValue += root.lazy;
            root.leftChild.lazy += root.lazy;
            root.rightChild.maxValue += root.lazy;
            root.rightChild.lazy += root.lazy;
            root.lazy = 0;
        }
    }

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
