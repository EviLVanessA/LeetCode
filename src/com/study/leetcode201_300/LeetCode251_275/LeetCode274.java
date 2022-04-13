package com.study.leetcode201_300.LeetCode251_275;

import java.util.Arrays;

public class LeetCode274 {
    /**
     * 默认排序
     *
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }

    /**
     * 使用计数排序
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        int n = citations.length, total = 0;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            //给每个论文引用分桶
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }

        for (int i = n; i >= 0; i--) {
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4, 6, 5};
        System.out.println(hIndex(arr));
    }
}
