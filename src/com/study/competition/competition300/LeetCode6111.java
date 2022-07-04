package com.study.competition.competition300;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-07-03 10:36
 */
public class LeetCode6111 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[m][n];
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        int i = 0;
        int x = 0, y = 0;
        if (head == null) {
            return ans;
        }
        ans[x][y] = head.val;
        head = head.next;
        visited[x][y] = 1;
        while (head != null) {
            int[] dir = dirs[i % 4];
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                ans[newX][newY] = head.val;
                head = head.next;
                visited[newX][newY] = 1;
                x = newX;
                y = newY;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //3,0,2,6,8,1,7,9,4,2,5,5,0
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(7);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(4);
        ListNode listNode9 = new ListNode(2);
        ListNode listNode10 = new ListNode(5);
        ListNode listNode11 = new ListNode(5);
        ListNode listNode12 = new ListNode(0);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        int[][] ints = new LeetCode6111().spiralMatrix(3, 5, listNode);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
