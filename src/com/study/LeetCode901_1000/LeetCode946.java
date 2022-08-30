package com.study.LeetCode901_1000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2022/8/30
 */
public class LeetCode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int n = pushed.length;
        int[] stack = new int[n];
        //两个指针i是 pushed数组的指针,popped数组的指针
        int i = 0, j = 0;
        for (int num : pushed) {
            stack[i] = num;
            while (i >= 0 && stack[i] == popped[j]) {
                //pop指针
                j++;
                i--;
            }
            i++;
        }
        return i == 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{4, 5, 3, 2, 1};
        System.out.println(new LeetCode946().validateStackSequences(arr1, arr2));
    }
}
