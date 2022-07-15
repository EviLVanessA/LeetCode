package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2022-07-14 21:01
 */
public class LeetCode558 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        //quadTree1是叶子结点
        if (quadTree1.isLeaf) {
            //值是true
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            //值不是true
            return quadTree2;
        }
        //quadTree2是叶子结点
        if (quadTree2.isLeaf) {
            //值是true
            if (quadTree2.val) {
                return new Node(true, true, null, null, null, null);
            }
            //值不是true
            return quadTree1;
        }
        //都不是叶子结点
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        //四个子节点都是叶子结点并且值相同
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
