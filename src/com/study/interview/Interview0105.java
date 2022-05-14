package com.study.interview;

/**
 * @author jianghui
 * @date 2022-05-14 09:42
 */
public class Interview0105 {
    public boolean oneEditAway(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        if (firstLength - secondLength == 1) {
            //第一个字符串比第二个字符串长一个字符
            return insertOneCharToShortString(first, second);
        } else if (secondLength - firstLength == 1) {
            //第二个字符串比第一个字符串长一个字符
            return insertOneCharToShortString(second, first);
        } else if (secondLength == firstLength) {
            //两个相等 只能做一次修改操作
            boolean edit = false;
            for (int i = 0; i < firstLength; i++) {
                if (first.charAt(i) == second.charAt(i)) {
                    continue;
                }
                //只能修改一次
                if (edit) {
                    return false;
                }
                edit = true;
            }
            return true;
        } else {
            //长度差距大于2
            return false;
        }
    }

    /**
     * 插入一个字符
     *
     * @param longString  长字符串
     * @param shortString 短字符串
     * @return
     */
    private boolean insertOneCharToShortString(String longString, String shortString) {
        int i = 0, j = 0;
        while (i < longString.length() && j < shortString.length()) {
            //相等 移动两个指针
            if (longString.charAt(i) == shortString.charAt(j)) {
                i++;
                j++;
            } else {
                //只移动长字符串的指针，相当于给短字符串插入一个字符
                i++;
            }
            //插入的操作 > 1
            if (i - j > 1) {
                return false;
            }
        }
        return true;
    }
}
