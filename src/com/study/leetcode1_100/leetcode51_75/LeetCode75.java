package com.study.leetcode1_100.leetcode51_75;

/**
 * 相关题88  215
 * @author jianghui
 * @date 2020-09-14  17:25
 **/
public class LeetCode75 {
    public void sortColors(int[] nums) {
        int[] arr = {0,0,0};
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr[0]; i++) {
            nums[i] = 0;
        }
        for (int i = arr[0]; i < arr[0] + arr[1]; i++) {
            nums[i] = 1;
        }
        for (int i = arr[0] + arr[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    /**
     * 三路快排进行
     * @param nums
     */
    public void sortColors1(int[] nums) {
        //[0...zero]的值都为0
        int zeros = -1;
        //[two...n-1]的值都为2
        int two = nums.length;

        for (int i = 0; i < two;) {
            if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                two--;
//                swap(nums[i],nums[two]);
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            }else {
                zeros ++;
//                swap(nums[zeros],nums[i]);
                int temp = nums[zeros];
                nums[zeros] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
    public void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
