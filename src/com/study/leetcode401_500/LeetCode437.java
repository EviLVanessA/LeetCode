package com.study.leetcode401_500;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 * @author jianghui
 * @date 2020-09-18  9:19
 **/
public class LeetCode437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int res = findPath(root , sum);
        //寻找不包含root的值的路径
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }

    /**
     * 在以node为结点的二叉树中，寻找包含node的路径，和为sum
     * 返回这样路径的个数
     * @param node
     * @param num
     * @return
     */
    private int findPath(TreeNode node,int num){
        if (node == null){
            return 0;
        }
        int res = 0;
        if (node.val == num){
            res += 1;
        }
        //在左右子树中寻找和为num的路径
        res += findPath(node.left,num-node.val);
        res += findPath(node.right,num-node.val);

        return res;
    }
}
