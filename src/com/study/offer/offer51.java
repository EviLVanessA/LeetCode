package com.study.offer;

/**
 * @author jianghui
 * @date 2022/5/17
 */
public class offer51 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int[] temp = new int[n];
        return mergeSort(nums, 0, n - 1, temp);
    }

    /**
     * 采用归并排序
     *
     * @param nums  待排序的数组
     * @param left  左边界
     * @param right 右边界
     * @param temp  临时存放数组
     * @return
     */
    private int mergeSort(int[] nums, int left, int right, int[] temp) {
        //只有一个元素 没有逆序对
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        //求出左边数组的逆序对
        int leftPairs = mergeSort(nums, left, mid, temp);
        //求出右边数组的逆序对
        int rightParis = mergeSort(nums, mid + 1, right, temp);
        //由于左右两个数组均有序，若左数组的最后一个节点 <= 右数组的最后一个节点
        //则整个【left，right】有序，这些元素不会贡献逆序对
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightParis;
        }
        //计算两个数组的元素 贡献的逆序对
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightParis + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        //临时存放元素
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //左数组已经全部遍历完毕
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                //右数组已经全部遍历完毕
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                //左节点小于等于右节点
                nums[k] = temp[i];
                i++;
            } else {
                //左节点大于右节点 会贡献逆序对
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
