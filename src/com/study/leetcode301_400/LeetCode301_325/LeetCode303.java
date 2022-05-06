package com.study.leetcode301_400.LeetCode301_325;

/**
 * @author jianghui
 * @date 2021-03-15 13:59
 */
public class LeetCode303 {
    /**
     * 使用线段树
     */
    class NumArray{
        private int[] data;
        private int[] tree;
        public NumArray(int[] nums) {
            data = new int[nums.length];
            System.arraycopy(nums, 0, data, 0, nums.length);
            tree = new int[4 * nums.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        public int sumRange(int left, int right) {
            return query(0, 0, data.length - 1, left, right);
        }
        private int query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            } else {
                return query(rightTreeIndex, mid + 1, r, mid + 1, queryR)+query(leftTreeIndex, l, mid, queryL, mid);
            }
        }
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }
    }

    /**
     * 使用前缀和
     */
    class NumArray2{
        int[] sums;

        public NumArray2(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }
}
