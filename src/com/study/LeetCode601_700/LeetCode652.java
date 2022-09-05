package com.study.LeetCode601_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找相同的子树
 *
 * @author jianghui
 * @date 2021-02-19 14:10
 */
public class LeetCode652 {
    public static class TreeNode {
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

        @Override
        public String toString() {
            return val + "";
        }
    }

//    Map<String, Integer> conut;
//    List<TreeNode> ans;
//
//    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
//        conut = new HashMap<>();
//        ans = new ArrayList<>();
//        dfs(root);
//        return ans;
//    }
//
//    /**
//     * 进行序列化
//     *
//     * @param root
//     * @return
//     */
//    private String dfs(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
//        conut.put(serial, conut.getOrDefault(serial, 0) + 1);
//        if (conut.get(serial) == 2) {
//            ans.add(root);
//        }
//        return serial;
//    }


    private int id;
    private Map<String, Integer> trees;
    private Map<Integer, Integer> count;
    private List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        id = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        int uid = trees.computeIfAbsent(serial, key -> id++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(root);
        }
        return uid;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(new LeetCode652().findDuplicateSubtrees(root));
    }
}
