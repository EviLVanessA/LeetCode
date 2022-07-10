package com.study.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-07-04 21:35
 */
public class MyCalendar3 {
    class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int start;
        private int end;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    public MyCalendar3() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }
        TreeNode p = root;
        while (true) {
            //在树的左侧
            if (end <= p.start) {
                if (p.left == null) {
                    p.left = new TreeNode(start, end);
                    return true;
                }
                p = p.left;
            } else if (start >= p.end) {
                //在树的右侧
                if (p.right == null) {
                    p.right = new TreeNode(start, end);
                    return true;
                }
                p = p.right;
            } else {
                //包含返回false
                return false;
            }
        }
    }

}
