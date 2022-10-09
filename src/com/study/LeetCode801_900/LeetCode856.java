package com.study.LeetCode801_900;

/**
 * @author jianghui
 * @date 2022/10/9
 */
public class LeetCode856 {
    public int scoreOfParentheses(String s) {
        //深度
        int dep = 0;
        //贡献值
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //计算深度
            dep += aChar == '(' ? 1 : -1;
            //找到一对 ()
            if (aChar == ')' && i >= 1 && chars[i - 1] == '(') {
                //计算贡献值
                ans += 1 << dep;
            }
        }
        return ans;
    }
}
