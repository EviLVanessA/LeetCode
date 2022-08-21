package com.study.LeetCode701_800;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jianghui
 * @date 2022-08-13 09:16
 */
public class LeetCode768 {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int num : arr) {
            //若当前栈为空或者栈顶元素小于等于当前元素，直接入栈
            if (stack.isEmpty() || stack.peek() <= num) {
                stack.push(num);
            } else {
                //融合块，保留当前块的最大元素
                //比如之前有块[3]、[4],若num = 1，
                //则融合为[3,4,1],因为排序1会排到前边去，当前块的最大值还是4
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }

    public int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        //前缀的最大值
        int[] prefixMax = new int[n];
        //后缀的最小值
        int[] suffixMin = new int[n];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }
        //最小一个块
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            //前缀的最大值，小于等于后缀的最小值，则这里可以划分
            if (prefixMax[i] <= suffixMin[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode768().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }
}
