package com.study.LeetCode1001_1100;

import com.study.LeetCode901_1000.LeetCode926;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2022-06-16 21:15
 */
public class LeetCode1089 {
    public void duplicateZeros(int[] arr) {
        //栈
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        while (queue.size() < arr.length) {
            //是0则多添加一个0
            if (arr[i] == 0) {
                queue.offerLast(arr[i]);
            }
            queue.offerLast(arr[i]);
            i++;
        }
        //有可能最后也是一个0，会多一个元素
        if (queue.size() > arr.length) {
            queue.pollLast();
        }
        //倒序放回原来数组
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = queue.pollLast();
        }
    }

    public void duplicateZeros2(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = 0;
        while (top < n) {
            if (arr[i] == 0) {
                top++;
            }
            i++;
            top++;
        }
        i--;
        int j = n - 1;
        if (top > n) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = 0;
                j--;
            }
            i--;
        }
    }

    public void duplicateZeros3(int[] arr) {
        int n = arr.length;
        //两个指针
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            //遇到0则top多向后移动一步 模拟添加一个0
            if (arr[i] == 0) {
                top++;
            }
            top++;
        }
        //有可能最后是一个0 会多移动两步，再移动回来
        if (top > n) {
            top = top - 2;
            arr[top] = 0;
            top--;
            i--;
        } else {
            //不是0则移动出去一步
            top--;
        }
        while (top >= 0) {
            //从后向前填充数据
            arr[top] = arr[i];
            top--;
            //是0 则多向前走一步 多添加一个0
            if (arr[i] == 0) {
                arr[top] = 0;
                top--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0};
        new LeetCode1089().duplicateZeros3(arr);
        System.out.println(Arrays.toString(arr));
    }
}
