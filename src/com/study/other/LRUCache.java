package com.study.other;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存 使用hashMap + 双向链表实现
 *
 * @author jianghui
 * @date 2021-01-07 16:32
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //放到双向链表的首部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        //假如key不存在
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity){
                Node delNode = removeTail();
                cache.remove(delNode.key);
                size--;
            }
        }else {
            //存在 修改value
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        //当前节点的前驱节点为head
        node.pre = dummyHead;
        //当前节点的后继节点为head.next
        node.next = dummyHead.next;
        //头节点的后继节点的前去节点为当前节点
        dummyHead.next.pre = node;
        //头节点的后继节点为当前节点
        dummyHead.next = node;
    }

    private void removeNode(Node node) {
        //当前节点的前驱的后继为当前节点的后继
        node.pre.next = node.next;
        //当前节点的后继的前驱为当前节点的前驱
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node ans = dummyTail.pre;
        removeNode(ans);
        return ans;
    }
}
