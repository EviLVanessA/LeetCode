package com.study.LeetCode601_700;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/26
 */
public class LeetCode699 {
    public List<Integer> fallingSquares2(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left1 = positions[i][0], right1 = positions[i][0] + positions[i][1];
            int height = positions[i][1];
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1];
                if (right1 > left2 && right2 > left1) {
                    height = Math.max(height, ans.get(j) + positions[i][1]);
                }
            }
            ans.add(height);
        }
        for (int i = 1; i < n; i++) {
            ans.set(i, Math.max(ans.get(i), ans.get(i - 1)));
        }
        return ans;
    }


    public List<Integer> fallingSquares3(int[][] positions) {
        Map<Integer, Integer> heightsMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int curMax = 0;
        for (int[] position : positions) {
            int left = position[0];
            int right = position[0] + position[1] - 1;
            int height = position[1];
            int maxHeight = 0;
            for (int j = left; j <= right; j++) {
                maxHeight = Math.max(maxHeight, heightsMap.getOrDefault(j, 0));
            }
            for (int j = left; j <= right; j++) {
                heightsMap.put(j, maxHeight + height);
            }
            curMax = Math.max(curMax, maxHeight + height);
            ans.add(curMax);
        }
        return ans;
    }


    static class Node {
        //左范围
        private final int leftX;
        //右范围
        private final int rightX;
        //最大高度
        private final int maxHeight;
        //右边界
        private int maxR;
        //左子树和右子树
        Node leftChild, rightChild;

        public Node(int leftX, int rightX, int height, int maxR) {
            this.leftX = leftX;
            this.rightX = rightX;
            this.maxHeight = height;
            this.maxR = maxR;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        //创建返回值
        List<Integer> res = new ArrayList<>();
        //根节点，默认为零
        Node root = null;
        //目前最高的高度
        int curMax = 0;
        for (int[] position : positions) {
            //左坐标
            int left = position[0];
            //右坐标
            int right = position[0] + position[1];
            //边长
            int edge = position[1];
            //当前最高的高度
            int curMaxHigh = query(root, left, right);
            //更新线段树 给所有范围更新最大值为curMaxHigh + edge
            root = update(root, left, right, curMaxHigh + edge);
            //高度比较
            curMax = Math.max(curMax, curMaxHigh + edge);
            res.add(curMax);
        }
        return res;
    }

    /**
     * 做区间更新
     *
     * @param root   根节点
     * @param left   左范围
     * @param right  右范围
     * @param height 高度
     * @return
     */
    private Node update(Node root, int left, int right, int height) {
        if (root == null) {
            return new Node(left, right, height, right);
        }
        if (left <= root.leftX) {
            root.leftChild = update(root.leftChild, left, right, height);
        } else {
            root.rightChild = update(root.rightChild, left, right, height);
        }
        root.maxR = Math.max(right, root.maxR);
        return root;
    }

    /**
     * 查询范围内的最大高度
     *
     * @param root  根节点
     * @param left  左范围
     * @param right 右范围
     * @return
     */
    private int query(Node root, int left, int right) {
        //如果新节点的左边界大于等于当前树的maxR的话,不需要遍历整颗树
        if (root == null || left >= root.maxR) {
            return 0;
        }
        int curHeight = 0;
        //是否有交集
        if (right > root.leftX && left < root.rightX) {
            curHeight = root.maxHeight;
        }
        curHeight = Math.max(curHeight, query(root.leftChild, left, right));
        if (right > root.leftX) {
            curHeight = Math.max(curHeight, query(root.rightChild, left, right));
        }
        return curHeight;
    }

    public static void main(String[] args) {
        int[][] ps = {{1, 2}, {2, 3}, {6, 1}};
        System.out.println(new LeetCode699().fallingSquares(ps));
    }
}
