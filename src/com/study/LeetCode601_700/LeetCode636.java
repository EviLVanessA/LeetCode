package com.study.LeetCode601_700;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-08-07 09:15
 */
public class LeetCode636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int pos = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if ("start".equals(split[1])) {
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    //暂停 栈顶元素执行时间
                    ans[peek[0]] += time - peek[1];
                    peek[1] = time;
                }
                stack.push(new int[]{pos, time});
            } else {
                int[] pop = stack.pop();
                ans[pop[0]] += time - pop[1] + 1;
                if (!stack.isEmpty()) {
                    //属于嵌套执行 恢复栈顶元素执行时间
                    stack.peek()[1] = time + 1;
                }
            }
        }
        return ans;
    }

    public int[] exclusiveTime2(int n, List<String> logs) {
        int[] ans = new int[n];
        //存放当前执行的 线程号
        Deque<Integer> stack = new ArrayDeque<>();
        int preTime = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            //当前时间
            int curTime = Integer.parseInt(split[2]);
            //当前的线程号
            int threadId = Integer.parseInt(split[0]);
            //当前线程的类型是 start
            if ("start".equals(split[1])) {
                if (!stack.isEmpty()) {
                    //挂起栈顶线程 记录答案
                    ans[stack.peek()] += curTime - preTime;
                }
                stack.push(threadId);
                preTime = curTime;
            } else {
                //当前线程的类型是 end
                ans[stack.pop()] += curTime - preTime + 1;
                //线程恢复
                preTime = curTime + 1;
            }
        }
        return ans;
    }
}
