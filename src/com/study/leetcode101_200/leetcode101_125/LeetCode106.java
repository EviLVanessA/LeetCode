package com.study.leetcode101_200.leetcode101_125;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2020-12-28 11:16
 */
public class LeetCode106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> indexMap;

    private TreeNode createTree(int[] postorder, int inorderRight, int postorderLeft, int postorderRight) {
        if (postorderLeft > postorderRight){
            return null;
        }
        //从后序遍历拿到根节点
        int rootVal = postorder[postorderRight];
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        //从中序遍历中获取该root的索引
        int inorderRootIndex = indexMap.get(rootVal);
        int subtreeSize = inorderRight - inorderRootIndex;
        //创建右子树
        root.right = createTree(postorder, inorderRight,
                postorderRight - subtreeSize, postorderRight - 1);
        root.left = createTree(postorder, inorderRootIndex - 1,
                postorderLeft, postorderRight - subtreeSize - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return createTree(postorder, n - 1, 0, n - 1);
    }
}
