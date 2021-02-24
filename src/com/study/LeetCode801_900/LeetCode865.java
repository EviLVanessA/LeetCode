package com.study.LeetCode801_900;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-02-23 15:19
 */
public class LeetCode865 {
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
    Map<TreeNode,Integer> depth;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        depth.put(null,-1);
        dfs(root,null);
        maxDepth = -1;
        for (Integer i : depth.values()){
            maxDepth = Math.max(maxDepth,i);
        }
        return ans(root);
    }
    private void dfs (TreeNode node,TreeNode parent){
        if (node != null){
            depth.put(node,depth.get(parent) + 1);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
    private TreeNode ans(TreeNode node){
        if (node == null || depth.get(node) == maxDepth){
            return node;
        }
        TreeNode left = ans(node.left);
        TreeNode right = ans(node.right);
        if (left != null && right != null){
            return node;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
