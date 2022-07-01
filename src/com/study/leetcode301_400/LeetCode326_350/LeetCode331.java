package com.study.leetcode301_400.LeetCode326_350;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jianghui
 * @date 2022/6/27
 */
public class LeetCode331 {
    public boolean isValidSerialization1(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }

    public boolean isValidSerialization3(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : preorder.split(",")) {
            stack.push(s);
            while (stack.size() >= 3
                    && "#".equals(stack.get(0))
                    && "#".equals(stack.get(1))
                    && !"#".equals(stack.get(2))) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && "#".equals(stack.pop());
    }

    public boolean isValidSerialization4(String preorder) {
        int diff = 1;
        String[] split = preorder.split(",");
        for (String s : split) {
            diff--;
            // 每加入一个节点 都要先减去一个入度   若该节点是非空节点 还要再加上两个出度
            // 遍历完之前，出度是大于等于入度的    1个出度认为提供一个挂载点  1个入度认为消耗一个挂载点
            // 若小于等于 消耗的挂载点 大于等于 提供的挂载点  不可能再继续遍历挂载剩下的节点了
            if (diff < 0) {
                return false;
            }
            if (!s.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode331().isValidSerialization4("9,#,92,#,#"));
    }
}
