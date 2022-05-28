package com.study.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/26
 */
public class SegmentTree {

    Node[] tree;
    int[] data;

    public SegmentTree(int[] data) {
        this.data = data;
        this.tree = new Node[4 * data.length];
    }

    static class Node {
        int left;
        int right;
        int lazy;
        int val;
    }

    private void build(int index, int left, int right) {
        tree[index] = new Node();
        tree[index].left = left;
        tree[index].right = right;
        if (left == right) {
            tree[index].val = data[right - 1];
            return;
        }
        int mid = left + (right - left) / 2;
        build(index * 2, left, mid);
        build(index * 2 + 1, mid + 1, right);
        tree[index].val = tree[index * 2].val + tree[index * 2 + 1].val;
    }

    private void pushDown(int index) {
        //下传lazy
        tree[index * 2].lazy += tree[index].lazy;
        tree[index * 2 + 1].lazy += tree[index].lazy;
        int mid = tree[index].left + (tree[index].right - tree[index].left) / 2;
        tree[index * 2].val += tree[index].lazy * (mid - tree[index].left + 1);
        tree[index * 2 + 1].val += tree[index].lazy * (tree[index].right - mid);
        //消除父节点lazy
        tree[index].lazy = 0;
    }

    private void update(int index, int left, int right, int value) {
        //如果当前区间被修改区间完全覆盖
        if (tree[index].right <= right && tree[index].left >= left) {
            //求和
            tree[index].val += (tree[index].right - tree[index].left + 1) * value;
            //懒标记
            tree[index].lazy = value;
            return;
        }
        if (tree[index].lazy != 0) {
            //如果当前节点有懒标记 做下沉操作
            pushDown(index);
        }
        //和左子树有交集
        if (tree[index * 2].right >= left) {
            update(index * 2, left, right, value);
        }
        //和右子树有交集
        if (tree[index * 2 + 1].left <= right) {
            update(index * 2 + 1, left, right, value);
        }
        tree[index].val = tree[index * 2].val + tree[index * 2 + 1].val;
    }

    private int query(int index, int left, int right) {
        //如果当前区间被修改区间完全覆盖
        int ans = 0;
        if (tree[index].right <= right && tree[index].left >= left) {
            return tree[index].val;
        }
        if (tree[index].lazy != 0) {
            pushDown(index);
        }
        if (tree[index * 2].right >= left) {
            ans += query(index * 2, left, right);
        }
        if (tree[index * 2 + 1].left <= right) {
            ans += query(index * 2 + 1, left, right);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SegmentTree segmentTree = new SegmentTree(nums);
        segmentTree.build(1, 1, 10);
        segmentTree.update(1, 3, 5, 2);
        System.out.println(segmentTree.query(1, 3, 5));
    }

}
