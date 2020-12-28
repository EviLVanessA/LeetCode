package com.study.leetcode101_200.leetcode151_175;

/**
 * 对撞指针(双索引技术)  125 344 245 11
 * @author jianghui
 * @date 2020-09-15  16:17
 **/
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target){
        int l = 0, r = numbers.length - 1;
        while (l < r){
            if (numbers[l] + numbers[r] == target){
                int[] res = {l+1,r+1};
                return res;
            }else if (numbers[l] + numbers[r] < target){
                l++;
            }else if (numbers[l] + numbers[r] > target){
                r--;
            }
        }
        return null;
    }
}
