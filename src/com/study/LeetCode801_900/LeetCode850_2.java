package com.study.LeetCode801_900;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-09-15 20:52
 */
public class LeetCode850_2 {
    class Solution {
        private static final int MOD = (int) 1e9 + 7;
        //常数in和out分别指示当前扫描线是入边或者出边
        private static final int IN = 1;
        private static final int OUT = -1;

        public int rectangleArea(int[][] rectangles) {
            //用TreeSet将纵坐标去重并用于后续离散化
            TreeSet<Integer> ySet = new TreeSet<>();
            //用正反两个HashMap存储离散化后坐标和实际纵坐标的关系
            Map<Integer, Integer> y2Index = new HashMap<>();
            Map<Integer, Integer> index2y = new HashMap<>();
            List<int[]> xList = new ArrayList<>();
            for (int[] rect : rectangles) {
                //记录入边 结构是 x -> y1 y2 1/-1
                xList.add(new int[]{rect[0], rect[1], rect[3], IN});
                //记录出边 结构是 x -> y1 y2 1/-1
                xList.add(new int[]{rect[2], rect[1], rect[3], OUT});
                ySet.add(rect[1]);
                ySet.add(rect[3]);
            }
            //将纵坐标离散化，从1开始
            int count = 1;
            for (int y : ySet) {
                //记录实际坐标和离散化坐标的关系
                y2Index.put(y, count);
                //记录离散化坐标和实际坐标的关系
                index2y.put(count, y);
                count++;
            }
            //按照x轴从小到大排序
            xList.sort(Comparator.comparingInt(x -> x[0]));
            //开线段树的根节点
            SegmentTree segmentTree = new SegmentTree();
            long ans = 0;
            int n = xList.size();
            for (int i = 0; i < n - 1; i++) {
                int[] cur = xList.get(i);
                //分别取出当前边的上下两个坐标
                int left = y2Index.get(cur[1]);
                int right = y2Index.get(cur[2]);
                //将当前的边的区间更新到线段树上
                segmentTree.update(left, right - 1, cur[3], index2y);
                ans += (long) segmentTree.query() * (xList.get(i + 1)[0] - cur[0]);
            }
            return (int) (ans % MOD);
        }
    }
}

class SegmentTree {

    private static final int maxNode = 201;

    public SegmentTree() {
        root = new TreeNode();
    }

    private TreeNode root;

    // 用于扫描线问题的线段树类
    private class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int coverLen;
        public int cover;
    }

    public void update(int left, int right, int value, Map<Integer, Integer> index2y) {
        update(root, 1, maxNode, left, right, value, index2y);
    }

    public int query() {
        return root.coverLen;
    }

    private void update(TreeNode root, int start, int end, int left, int right, int value, Map<Integer, Integer> index2y) {
        //先为当前节点动态开左右节点
        createNode(root);
        if (left <= start && end <= right) {
            root.cover += value;
            //pushUp更新当前节点的区间长度
            pushUp(root, start, end, index2y);
            return;
        }
        int mid = start + (end - start) / 2;
        // 分别更新左右区间
        if (left <= mid) {
            update(root.left, start, mid, left, right, value, index2y);
        }
        if (mid < right) {
            update(root.right, mid + 1, end, left, right, value, index2y);
        }
        // ushUp更新当前节点的区间长度
        pushUp(root, start, end, index2y);
    }

    // 更新线段树节点对应的区间长度
    private void pushUp(TreeNode root, int start, int end, Map<Integer, Integer> index2y) {
        // root.cover是更新到整个区间上所有边的in或者out标记之和，
        // 如果cover > 0，则当前区间被完全覆盖，通过index2y找到实际的覆盖长度
        if (root.cover > 0) {
            root.coverLen = index2y.get(end + 1) - index2y.get(start);
        } else if (start != end) {
            // cover == 0，则表示该区间没有被完全覆盖，直接相加左右子树的覆盖长度
            root.coverLen = root.left.coverLen + root.right.coverLen;
        } else {
            // 如果 start == end，不代表任何区间，长度是0
            root.coverLen = 0;
        }
    }

    // 动态开左右节点
    private void createNode(TreeNode root) {
        if (root.left == null) {
            root.left = new TreeNode();
        }
        if (root.right == null) {
            root.right = new TreeNode();
        }
    }

}
