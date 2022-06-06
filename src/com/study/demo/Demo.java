package com.study.demo;

import com.study.leetcode401_500.LeetCode450;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class Demo {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            //当前节点的值大于 目标值去左子树寻找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            //当前节点的值小于 目标值去右子树寻找
            root.right = deleteNode(root.right, key);
        } else {
            //情况一可以和二三合并处理
            //情况二
            if (root.left == null) {
                return root.right;
            }
            //情况三
            if (root.right == null) {
                return root.left;
            }
            //情况四
            //找到右节点的左子树中为空的位置
            TreeNode rightNode = root.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            rightNode.left = root.left;
            root = root.right;
        }
        return root;
    }

}
