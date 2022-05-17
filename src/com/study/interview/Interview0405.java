package com.study.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/16
 */
public class Interview0405 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode ans = null;
        while (cur != null) {
            if (cur.val > p.val) {
                ans = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return ans;
    }
}
