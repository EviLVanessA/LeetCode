package com.study.leetcode101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历 非递归
 * @author jianghui
 * @date 2020-09-17  9:37
 **/
public class LeetCode144 {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class Command{
        String s;
        TreeNode node;
        Command(String s,TreeNode node){
            this.node = node;
            this.s = s;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while (!stack.empty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                list.add(command.node.val);
            }else {
                if (command.node.right != null){
                    stack.push(new Command("go",command.node.right));
                }
                if (command.node.left != null){
                    stack.push(new Command("go",command.node.left));
                }
                command.s = "print";
                stack.push(command);
            }
        }
        return list;
    }
}
