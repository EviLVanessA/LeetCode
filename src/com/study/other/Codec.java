package com.study.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-02-02 10:41
 */
public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    private TreeNode rDeserialize(List<String> list) {
        if ("None".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }

    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        return rDeserialize(list);
    }
}
