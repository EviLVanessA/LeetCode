package com.study.leetcode1_100.leetcode1_25;

import java.util.HashMap;
import java.util.Map;

/**
 * 相关题 15 16 18
 *
 * @author jianghui
 * @date 2020-09-15  17:50
 **/
public class LeetCode1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] twoSum = twoSum(arr, 4);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> record = new HashMap<>();
        for (int i = 0;i < nums.length ; i++){
            int complement = target - nums[i];
            if (record.containsKey(complement)){
                int res[] = {i,record.get(complement)};
                return res;
            }
            record.put(nums[i],i);
        }
        return null;
    }
}
