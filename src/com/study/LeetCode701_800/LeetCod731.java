package com.study.LeetCode701_800;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jianghui
 * @date 2022/7/18
 */
public class LeetCod731 {
    public static void main(String[] args) {
        MyCalendarTwo2 myCalendarTwo2 = new MyCalendarTwo2();
        System.out.println(myCalendarTwo2.book(24, 40));
        System.out.println(myCalendarTwo2.book(43, 50));
        System.out.println(myCalendarTwo2.book(27, 43));
        System.out.println(myCalendarTwo2.book(5, 21));
        System.out.println(myCalendarTwo2.book(30, 40));
        System.out.println(myCalendarTwo2.book(14, 29));
        System.out.println(myCalendarTwo2.book(3, 19));
        System.out.println(myCalendarTwo2.book(3, 14));
        System.out.println(myCalendarTwo2.book(25, 39));
        System.out.println(myCalendarTwo2.book(6, 19));
    }
}

class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>((x, y) -> y - x);
    }

    public boolean book(int start, int end) {
        int temp = 0;
        int ans = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        //恢复所有的值 采取了逆向恢复 和正向恢复都一样
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            temp = temp - entry.getValue();
            ans = Math.max(ans, temp);
            if (ans > 2) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

}


class MyCalendarTwo2 {
    /**
     * 线段树的结点
     */
    static class Node {
        //左范围
        private int leftX;
        //右范围
        private int rightX;
        //最大值
        private int max;
        //懒标记 0表示不需要操作
        private int lazy;
        //左子树和右子树
        Node leftChild, rightChild;

        public Node(int leftX, int rightX) {
            this.leftX = leftX;
            this.rightX = rightX;
        }
    }

    private Node root;

    /**
     * 区间更新
     *
     * @param root  树的根
     * @param left  左边界
     * @param right 有边界
     * @param value 更新值,删除则相当于置为0
     */
    public void update(Node root, int left, int right, int value) {
        //不在范围内 直接返回
        if (root.leftX > right || root.rightX < left) {
            return;
        }
        //修改的区间包含当前结点
        if (root.leftX >= left && root.rightX <= right) {
            root.max += value;
            root.lazy += value;
        } else {
            //动态开点
            lazyCreate(root);
            //下传lazy
            pushDown(root);
            //更新左子树
            update(root.leftChild, left, right, value);
            //更新右子树
            update(root.rightChild, left, right, value);
            //上传结果
            pushUp(root);
        }
    }

    public int query(Node root, int left, int right) {
        if (left <= root.leftX && root.rightX <= right) {
            return root.max;
        }
        lazyCreate(root);
        pushDown(root);
        int mid = root.leftX + (root.rightX - root.leftX) / 2;
        if (right <= mid) {
            return query(root.leftChild, left, right);
        } else if (left > mid) {
            return query(root.rightChild, left, right);
        } else {
            return Math.max(query(root.leftChild, left, mid), query(root.rightChild, mid + 1, right));
        }
    }

    /**
     * 创建左右子树
     *
     * @param root
     */
    public void lazyCreate(Node root) {
        if (root.leftChild == null) {
            root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.leftX + (root.rightX - root.leftX) / 2 + 1, root.rightX);
        }
    }

    /**
     * 下传lazy
     *
     * @param root
     */
    public void pushDown(Node root) {
        if (root.lazy > 0) {
            int value = root.lazy;
            root.leftChild.lazy += value;
            root.rightChild.lazy += value;
            root.leftChild.max += value;
            root.rightChild.max += value;
            root.lazy = 0;
        }
    }

    /**
     * 上传结果
     *
     * @param root
     */
    public void pushUp(Node root) {
        root.max = Math.max(root.leftChild.max, root.rightChild.max);
    }

    public MyCalendarTwo2() {
        root = new Node(0, (int) 1e9);
    }

    public boolean book(int start, int end) {
        int query = query(root, start, end - 1);
        if (query >= 2) {
            return false;
        }
        update(root, start, end - 1, 1);
        return true;
    }

}

