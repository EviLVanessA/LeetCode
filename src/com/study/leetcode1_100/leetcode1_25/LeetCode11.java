package com.study.leetcode1_100.leetcode1_25;

/**
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author jianghui
 * @date 2020-09-24  16:37
 **/
public class LeetCode11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new LeetCode11().maxArea(arr));
    }
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0,right = len - 1;
        int area = 0;
        while (left < right){
            int newArea = Math.min(height[left],height[right]) * (right-left);
            area = Math.max(area,newArea);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
