package com.study.sort;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-04-02 11:19
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {4, 5, 1, 2, 6, 7};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, swap;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //基准位
        temp = arr[low];

        while (i < j) {
            //找第一个小于temp的数
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
            }
        }
        arr[low] = arr[j];
        arr[j] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
