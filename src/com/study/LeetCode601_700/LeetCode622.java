package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/8/2
 */
public class LeetCode622 {
}

class MyCircularQueue {

    int[] queue;
    int rear;
    int front;
    int size;

    public MyCircularQueue(int k) {
        this.size = k + 1;
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    public boolean enQueue(int value) {
        if ((rear + 1) % size == front) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deQueue() {
        if (front == rear) {
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    public int Front() {
        if (front == rear) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (front == rear) {
            return -1;
        }
        return queue[(rear + size - 1) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return ((rear + 1) % size) == front;
    }
}
