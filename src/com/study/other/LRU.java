package com.study.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-03-26 09:27
 */
public class LRU {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Node dummyHead;
    private Node dummyTail;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    //添加元素
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addHead(newNode);
            this.size++;
            if (size > capacity) {
                Node delNode = removeLast();
                cache.remove(delNode.key);
                this.size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addHead(Node node) {
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        node.prev = dummyHead;
        dummyHead.next = node;
    }

    private Node removeLast() {
        Node delNode = dummyTail.prev;
        remove(delNode);
        return delNode;
    }

    private void moveToHead(Node node) {
        remove(node);
        addHead(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Node pre = dummyHead.next;
        while (pre != dummyTail) {
            list.add(pre.key);
            pre = pre.next;
        }
        return list.toString();
    }
}
