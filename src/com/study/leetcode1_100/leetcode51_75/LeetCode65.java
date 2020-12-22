package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-17 08:45
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        char[] arr = s.trim().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                numFlag = true;
            } else if (arr[i] == '.') {
                if (dotFlag || eFlag) {
                    return false;
                }
                dotFlag = true;
            } else if (arr[i] == 'E' || arr[i] == 'e') {
                if (eFlag || !numFlag) {
                    return false;
                }
                eFlag = true;
                numFlag = false;
            } else if (arr[i] == '+' || arr[i] == '-') {
                if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numFlag;
    }

    public int make(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case '.':
                return 3;
            case 'e':
                return 4;
            default:
                if (c >= 48 && c <= 57) {
                    return 2;
                }
        }
        return -1;
    }

    public boolean isNumber2(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{0, 1, 6, 2, -1},
                {-1, -1, 6, 2, -1},
                {-1, -1, 3, -1, -1},
                {8, -1, 3, -1, 4},
                {-1, 7, 5, -1, -1},
                {8, -1, 5, -1, -1},
                {8, -1, 6, 3, 4},
                {-1, -1, 5, -1, -1},
                {8, -1, -1, -1, -1}};
        char[] ss = s.toCharArray();
        for (char c : ss) {
            int id = make(c);
            if (id < 0) {
                return false;
            }
            state = transfer[state][id];
            if (state < 0) {
                return false;
            }
        }
        return (finals & (1 << state)) > 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode65().isNumber2("0.e1"));
    }
}
