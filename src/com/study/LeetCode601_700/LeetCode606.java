package com.study.LeetCode601_700;

import java.util.ArrayList;
import java.util.List;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * @author jianghui
 * @date 2021-02-18 10:04
 */
public class LeetCode606 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        preOrder(t, null);
        return ans.toString();
    }

    private void preOrder(TreeNode root, TreeNode parent) {
        if (root != null) {
            if (parent == null) {
                ans.append(root.val);
                preOrder(root.left, root);
                preOrder(root.right, root);
            } else {
                ans.append("(").append(root.val);
                preOrder(root.left, root);
                preOrder(root.right, root);
                ans.append(")");
            }
        } else {
            if (parent.left == null && parent.right != null) {
                ans.append("()");
            }
        }
    }
}
