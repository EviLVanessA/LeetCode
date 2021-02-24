package com.study.LeetCode801_900;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2021-02-24 09:53
 */
public class LeetCode889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (n == 1) {
            return root;
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (post[i] == pre[1]) {
                left = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, left + 1),
                Arrays.copyOfRange(post, 0, left));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, left + 1, n), Arrays.copyOfRange(post, left, n - 1));
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,6,7};
        arr = Arrays.copyOfRange(arr,1,4);
        System.out.println(Arrays.toString(arr));
    }
}
