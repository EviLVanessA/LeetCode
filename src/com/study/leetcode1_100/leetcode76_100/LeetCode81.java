package com.study.leetcode1_100.leetcode76_100;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * @author jianghui
 * @date 2020-12-22 09:18
 */
public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //不知道是否有序
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            //前半部分为有序状态
            if (nums[l] < nums[mid]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                //后半部分有序
            } else {
                if (nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
