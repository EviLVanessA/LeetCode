package com.study.LeetCode1301_1400;

/**
 * @author jianghui
 * @date 2022/8/1
 */
public class LeetCode1374 {
//    public String generateTheString(int n) {
//        StringBuffer ans = new StringBuffer();
//        if (n % 2 == 1) {
//            return ans.append("a".repeat(n)).toString();
//        }
//        return ans.append("a".repeat(n - 1)).append("b").toString();
//    }

    public String generateTheString2(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append("a");
        }
        if (n % 2 == 0) {
            ans.deleteCharAt(n - 1).append("b");
        }
        return ans.toString();
    }
}
