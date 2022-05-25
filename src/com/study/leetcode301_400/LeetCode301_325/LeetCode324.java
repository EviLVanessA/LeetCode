package com.study.leetcode301_400.LeetCode301_325;

import com.study.leetcode1_100.leetcode1_25.LeetCode3;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/23
 */
public class LeetCode324 {
    public void wiggleSort1(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        //两个指针
        int left = (nums.length - 1) / 2, right = nums.length - 1;
        //依次放置
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        //5001个桶
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int j = 5000;
        //插空放 较大元素
        for (int i = 1; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        //插空放 较小元素
        for (int i = 0; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }


    public void wiggleSort3(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new LeetCode324().wiggleSort1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
