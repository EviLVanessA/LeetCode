package com.study.leetcode201_300;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 类似问题26 27 80
 * @author jianghui
 * @date 2020-09-14  16:29
 **/
public class LeetCode283 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        moveZeroes(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size() ; i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public static void moveZeroes1(int[] nums) {
        //K为非零元素的索引
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
    public static void moveZeroes2(int[] nums) {
        //K为非零元素的索引
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i != k){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
    }
}
