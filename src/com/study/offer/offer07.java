package com.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author jianghui
 * @date 2021-01-28 15:21
 */
public class offer07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, indexMap);
    }

    private TreeNode createTree(int[] preorder, int preorderLeft, int preorderRight,
                                int inorderLeft, int inorderRight, Map<Integer, Integer> indexMap) {
        //左边界大于右边界
        if (preorderLeft > preorderRight) {
            return null;
        }
        //根节点的值为前序遍历的第一个节点
        int rootVal = preorder[preorderLeft];
        TreeNode root = new TreeNode(rootVal);
        //返回该节点在中序遍历中的位置
        int rootIndex = indexMap.get(rootVal);
        //获取左子树的长度
        int subLeftTreeSize = rootIndex - inorderLeft;
        root.left = createTree(preorder, preorderLeft + 1,
                preorderLeft + subLeftTreeSize, inorderLeft, rootIndex - 1, indexMap);
        root.right = createTree(preorder, preorderLeft + subLeftTreeSize + 1, preorderRight,
                rootIndex + 1, inorderRight, indexMap);
        return root;

    }
}
