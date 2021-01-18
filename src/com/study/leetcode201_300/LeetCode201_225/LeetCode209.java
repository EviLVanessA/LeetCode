package com.study.leetcode201_300.LeetCode201_225;

/**
 * 滑动窗口（两个指针）
 * @author jianghui
 * @date 2020-09-15  16:34
 **/
public class LeetCode209 {
    public int minSubArrayLen(int s,int[] nums){
        //l-r为滑动窗口,滑动窗口中默认无数据
        int l = 0,r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length){
            if (sum < s && r+1 < nums.length){
                r++;
                sum += nums[r];
            }else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s){
                res = Math.min(res,r-l+1);
            }
        }
        if (res == nums.length + 1){
            return 0;
        }
        return res;
    }
}
