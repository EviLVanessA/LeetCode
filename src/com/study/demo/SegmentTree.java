package com.study.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/26
 */
public class SegmentTree {

    /**
     * 树
     */
    private Node[] tree;
    /**
     * 原始数据
     */
    private int[] data;

    public SegmentTree(int[] data) {
        this.data = data;
        this.tree = new Node[4 * data.length];
    }

    /**
     * 内部节点
     */
    static class Node {
        /**
         * 左范围
         */
        private int left;
        /**
         * 右范围
         */
        private int right;
        /**
         * 懒标记
         */
        private int lazy;
        /**
         * 值
         */
        private int val;
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
        //构建左节点 坐标为index * 2
        build(index * 2, left, mid);
        //构建右节点 坐标为index * 2 + 1
        build(index * 2 + 1, mid + 1, right);
        //更新值
        tree[index].val = tree[index * 2].val + tree[index * 2 + 1].val;
    }


    /**
     * 更新区间
     *
     * @param index 索引
     * @param left  左范围
     * @param right 右范围
     * @param value 值
     */
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
        pushUp(index);
    }

    /**
     * 下传lazy
     *
     * @param index 索引
     */
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

    /**
     * 上传结果
     *
     * @param index 索引
     */
    private void pushUp(int index) {
        tree[index].val = tree[index * 2].val + tree[index * 2 + 1].val;
    }

    /**
     * 查询
     *
     * @param index 索引
     * @param left  左范围
     * @param right 右范围
     * @return
     */
    private int query(int index, int left, int right) {
        int ans = 0;
        //如果当前区间被完全覆盖，直接返回结果
        if (tree[index].right <= right && tree[index].left >= left) {
            return tree[index].val;
        }
        //需要向下继续遍历，把懒标记也下传下去
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
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree segmentTree = new SegmentTree(nums);
        segmentTree.build(1, 1, 8);
        System.out.println(segmentTree.query(1, 3, 5));
        segmentTree.update(1, 3, 5, 2);
        System.out.println(segmentTree.query(1, 3, 5));
        segmentTree.update(1, 3, 5, 1);
        System.out.println(segmentTree.query(1, 3, 5));

    }

}
