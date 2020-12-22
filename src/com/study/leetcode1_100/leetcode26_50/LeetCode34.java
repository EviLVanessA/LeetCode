package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * @author jianghui
 * @date 2020-09-28  10:13
 **/
public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ints = new LeetCode34().searchRange(nums, 8);
        System.out.println(ints[0] + " " + ints[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0){
            return new int[]{-1,-1};
        }
        if (n == 1){
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }

        int l = 0 ,r = n -1;
        int ll = -1,rr = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (target < nums[mid]){
                r = mid - 1;
            }else if (target > nums[mid]){
                l = mid + 1;
            }else {
                ll=mid;
                rr=mid;
                break;
            }
        }
        int i = ll,j=rr;
        while (i-1 >= 0 && nums[i-1] == target){
            i--;
        }
        while (j+1 < n && nums[j+1] == target){
            j++;
        }
        return new int[]{i,j};
    }

}
