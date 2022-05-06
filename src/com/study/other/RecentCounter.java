package com.study.other;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianghui
 * @date 2022/5/6
 */
public class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        //新建一个队列
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        //加入队尾
        queue.offer(t);
        //判断队头是否在窗口外 是，则出队
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        //返回队列元素的个数
        return queue.size();
    }
}
