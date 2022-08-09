package com.study.LeetCode601_700;

/**
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * @author jianghui
 * @date 2022/8/9
 */
public class LeetCode640 {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        int leftCountX = 0;
        int rightCountX = 0;
        int leftResult = 0;
        int rightResult = 0;
        int sign = 1, i = 0;
        while (i < left.length()) {
            char c = left.charAt(i);
            if (c == 'x') {
                if (sign == 1) {
                    leftCountX++;
                } else {
                    leftCountX--;
                }
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '+') {
                sign = 1;
                i++;
            } else {
                int num = 0;
                while (i < left.length() && Character.isDigit(left.charAt(i))) {
                    num = num * 10 + left.charAt(i) - '0';
                    i++;
                }
                num = num * sign;
                if (i < left.length() && left.charAt(i) == 'x') {
                    leftCountX += num;
                    i++;
                } else {
                    leftResult += num;
                }
            }
        }
        sign = 1;
        i = 0;
        while (i < right.length()) {
            char c = right.charAt(i);
            if (c == 'x') {
                if (sign == 1) {
                    rightCountX++;
                } else {
                    rightCountX--;
                }
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '+') {
                sign = 1;
                i++;
            } else {
                int num = 0;
                while (i < right.length() && Character.isDigit(right.charAt(i))) {
                    num = num * 10 + right.charAt(i) - '0';
                    i++;
                }
                num = num * sign;
                if (i < right.length() && right.charAt(i) == 'x') {
                    rightCountX += num;
                    i++;
                } else {
                    rightResult += num;
                }
            }
        }
        if (leftCountX == rightCountX && leftResult == rightResult) {
            return "Infinite solutions";
        } else if (leftCountX == rightCountX && leftResult != rightResult) {
            return "No solution";
        } else {
            int x = leftCountX - rightCountX;
            int y = rightResult - leftResult;
            int ans = y / x;
            return "x=" + ans;
        }
    }

    private int xSum;
    private int valSum;

    public String solveEquation2(String equation) {
        String[] split = equation.split("=");
        parseString(split[0], 1);
        parseString(split[1], -1);
        if (xSum == 0) {
            return valSum == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + (-valSum / xSum);
        }
    }

    public void parseString(String equation, int sign) {
        int i = 0, curSign = 1;
        while (i < equation.length()) {
            char c = equation.charAt(i);
            if (c == 'x') {
                if (sign * curSign == 1) {
                    xSum++;
                } else {
                    xSum--;
                }
                i++;
            } else if (c == '-' || c == '+') {
                curSign = c == '-' ? -1 : 1;
                i++;
            } else {
                int num = 0;
                while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                    num = num * 10 + equation.charAt(i) - '0';
                    i++;
                }
                num = num * sign * curSign;
                if (i < equation.length() && equation.charAt(i) == 'x') {
                    xSum += num;
                    i++;
                } else {
                    valSum += num;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode640().solveEquation2("2x+3x-6x=x+2"));
    }
}
