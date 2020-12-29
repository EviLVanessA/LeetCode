package com.study.leetcode101_200.leetcode101_125;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * @author jianghui
 * @date 2020-12-28 09:39
 */
public class LeetCode105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> indexMap;

    private TreeNode createTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        //前序遍历的第一个节点就是根节点 在中序遍历中找到该根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        //创建根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        //得到左子树的节点的个数 inorderRoot和inorderLeft是数组索引的位置
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        //创建左子树
        root.left = createTree(preorder, preorderLeft + 1,
                preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        root.right = createTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight,
                inorderRoot + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return createTree(preorder,0,n-1,0,n-1);
    }
}
