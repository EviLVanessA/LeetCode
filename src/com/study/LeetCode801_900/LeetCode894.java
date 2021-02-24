package com.study.LeetCode801_900;

import java.util.*;

/**
 * @author jianghui
 * @date 2021-02-24 16:02
 */
public class LeetCode894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, List<TreeNode>> memory = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memory.containsKey(N)) {
            List<TreeNode> ans = new ArrayList<>();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; x++) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x)) {
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            ans.add(root);
                        }
                    }
                }
            }
            memory.put(N, ans);
        }
        return memory.get(N);
    }
}
