package com.study.leetcode301_400.LeetCode301_325;

/**
 * @author jianghui
 * @date 2021-03-15 14:04
 */
public class LeetCode307 {
    class NumArray {
        private int[] data;
        private int[] tree;

        public NumArray(int[] nums) {
            data = new int[nums.length];
            System.arraycopy(nums, 0, data, 0, nums.length);
            tree = new int[4 * nums.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        public void update(int index, int val) {
            data[index] = val;
            update(0, 0, data.length - 1, index, val);
        }

        /**
         * 在以treeIndex为根的线段树中更新index的值为val
         *
         * @param treeIndex
         * @param l
         * @param r
         * @param index
         * @param val
         */
        private void update(int treeIndex, int l, int r, int index, int val) {
            if (l == r) {
                tree[treeIndex] = val;
                return;
            }
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (index >= mid + 1) {
                update(rightTreeIndex, mid + 1, r, index, val);
            } else {
                update(leftTreeIndex, l, mid, index, val);
            }
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
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
                return query(rightTreeIndex, mid + 1, r, mid + 1, queryR) + query(leftTreeIndex, l, mid, queryL, mid);
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
}
