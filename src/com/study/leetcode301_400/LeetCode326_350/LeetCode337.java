package com.study.leetcode301_400.LeetCode326_350;

import com.study.other.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 二叉树
 *
 * @author jianghui
 * @date 2021-01-25 16:20
 */
public class LeetCode337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, Integer> memory = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memory.containsKey(root)) {
            return memory.get(root);
        }
        int robIt = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notRob = rob(root.left) + rob(root.right);

        int ans = Math.max(robIt, notRob);
        memory.put(root, ans);
        return ans;
    }

    public int rob2(TreeNode root) {
        int[] ans = dp(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        //数组 表示 0表示不抢 1表示抢
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //抢当前节点
        int robIt = root.val + left[0] + right[0];
        //不抢当前节点
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{notRob, robIt};
    }
}
