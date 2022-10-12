package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-09-22 20:47
 */
public class LeetCode707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0, 10); //10
        linkedList.addAtIndex(0, 20); //20->10
        linkedList.addAtIndex(1, 30); //20->30->10
        System.out.println(linkedList.get(0));
    }
}

class MyLinkedList {

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        //创建一个带头结点的
        this.head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    public int get(int index) {
        if (index > size - 1) {
            return -1;
        }
        Node cur = head.next;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        this.size++;
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        if (size == 1) {
            tail = node;
        }
    }

    public void addAtTail(int val) {
        this.size++;
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        int i = 0;
        //找到index的前一个元素
        while (i < index) {
            cur = cur.next;
            i++;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            return;
        }
        Node cur = head;
        int i = 0;
        //找到前一个结点
        while (i < index) {
            cur = cur.next;
            i++;
        }
        if (cur.next == tail) {
            tail = cur;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        this.size--;
    }
}
