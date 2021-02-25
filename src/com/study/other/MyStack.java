package com.study.other;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2021-02-25 16:04
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queue1.isEmpty()){
            return queue1.poll();
        }
        return 0;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!queue1.isEmpty()){
            return queue1.peek();
        }
        return 0;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
