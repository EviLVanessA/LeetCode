package com.study.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2021-01-08 15:23
 */
public class MinStack2 {
    private Deque<int[]> stack;

    public MinStack2() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(new int[]{x, x});
        }else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
