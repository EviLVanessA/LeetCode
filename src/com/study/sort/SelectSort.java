package com.study.sort;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-04-02 11:08
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] data = {4,5,1,2,6,7};
        selectSort(data);
        System.out.println(Arrays.toString(data));
    }
    public static void selectSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            int flag = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < temp){
                    temp = data[j];
                    flag = j;
                }
            }
            if (flag != i){
                data[flag] = data[i];
                data[i] = temp;
            }
        }
    }
}
