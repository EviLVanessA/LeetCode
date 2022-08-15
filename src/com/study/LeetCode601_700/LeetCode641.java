package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/8/15
 */
public class LeetCode641 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(8);
        System.out.println(myCircularDeque.insertFront(5));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.isEmpty());
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.insertLast(3));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.insertLast(7));
        System.out.println(myCircularDeque.insertFront(7));
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertLast(4));
        System.out.println(myCircularDeque.isEmpty());


    }
}

class MyCircularDeque {

    class Node {
        /**
         * 节点的值
         */
        private int val;
        /**
         * 节点的下一个节点
         */
        private Node next;
        /**
         * 节点的上一个节点
         */
        private Node pre;

        public Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    /**
     * 容器的最大值
     */
    private int maxSize;
    /**
     * 容器的最小值
     */
    private int curSize;
    /**
     * 头指针
     */
    private Node head = null;
    /**
     * 尾指针
     */
    private Node tail = null;

    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.curSize = 0;
    }

    public boolean insertFront(int value) {
        //判断是否已满
        if (isFull()) {
            return false;
        }
        Node node = new Node(value, null, null);
        if (curSize == 0) {
            //是否为初始化
            head = tail = node;
        } else {
            //插入节点
            node.next = head;
            head.pre = node;
            head = node;
        }
        curSize++;
        return true;
    }

    public boolean insertLast(int value) {
        //判断是否已满
        if (isFull()) {
            return false;
        }
        Node node = new Node(value, null, null);
        if (curSize == 0) {
            //是否为初始化
            head = tail = node;
        } else {
            //插入节点
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
        curSize++;
        return true;
    }

    public boolean deleteFront() {
        //判断是否为空
        if (isEmpty()) {
            return false;
        }
        curSize--;
        Node next = head.next;
        //让删除节点指向null 方便垃圾回收
        head.next = null;
        if (next != null) {
            next.pre = null;
        }
        head = next;
        return true;
    }

    public boolean deleteLast() {
        //判断是否为空
        if (isEmpty()) {
            return false;
        }
        curSize--;
        //让删除节点指向null 方便垃圾回收
        Node pre = tail.pre;
        if (pre != null) {
            pre.next = null;
        }
        tail.pre = null;
        tail = pre;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }
}
