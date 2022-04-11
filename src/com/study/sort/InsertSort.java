package com.study.sort;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-04-02 10:56
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = {4,5,1,2,6,7};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void insertSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (data[j] > temp) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = temp;
        }
    }
}
