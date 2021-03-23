package com.study.leetcode201_300.LeetCode226_250;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * @author jianghui
 * @date 2021-03-03 09:38
 */
public class LeetCode239 {
    /**
     * 使用优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    /**
     * 使用双端队列(单调队列)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //创建双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        //先初始化前K个元素
        for (int i = 0; i < k; i++) {
            //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            //由于需要判断当前元素是否在窗口中，所以实际上队列中存储的为当前元素的下标
            //根据下标找元素比根据元素找下标方便
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        //添加当前最大元素
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            deque.offerLast(i);
            //判断队首元素是否在窗口中
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //添加答案
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1]);
        queue.offer(new int[]{1, 0});
        queue.offer(new int[]{5, 1});
        queue.offer(new int[]{1, 2});
        queue.offer(new int[]{4, 3});
        queue.offer(new int[]{7, 4});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            System.out.println(poll[0] + "   " + poll[1]);
        }
    }
}
