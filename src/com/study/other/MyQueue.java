package com.study.other;

import java.util.Stack;

/**
 * @author jianghui
 * @date 2021-03-01 20:43
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty();
    }
}
