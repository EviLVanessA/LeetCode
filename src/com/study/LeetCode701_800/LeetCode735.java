package com.study.LeetCode701_800;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2022/7/12
 */
public class LeetCode735 {
    public int[] asteroidCollision1(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                if (stack.peek() > 0 && asteroid < 0) {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                        stack.pop();
                        continue;
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                    }
                } else {
                    stack.push(asteroid);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollLast();
        }
        return ans;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean alive = true;
                while (alive && !stack.isEmpty() && stack.peek() > 0) {
                    alive = stack.peek() < Math.abs(asteroid);
                    if (stack.peek() <= Math.abs(asteroid)) {
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(asteroid);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode735 leetCode735 = new LeetCode735();
        System.out.println(Arrays.toString(leetCode735.asteroidCollision(new int[]{10, 2, -5})));
    }
}
