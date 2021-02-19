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

    Map<String, Integer> conut;


    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        conut = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }

    /**
     * 进行序列化
     *
     * @param root
     * @return
     */
    private String collect(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        conut.put(serial, conut.getOrDefault(serial, 0) + 1);
        if (conut.get(serial) == 2) {
            ans.add(root);
        }
        return serial;
    }


    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> conut2;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        conut2 = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    private int lookup(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String serial = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int uid = trees.computeIfAbsent(serial, key -> t++);
        conut2.put(uid, conut2.getOrDefault(uid, 0) + 1);
        if (conut2.get(uid) == 2) {
            ans.add(root);
        }
        return uid;
    }
}
