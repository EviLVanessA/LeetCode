package com.study.competition.competition301;

/**
 * @author jianghui
 * @date 2022-07-10 11:15
 */
public class LeetCode6114 {
    public boolean canChange(String start, String target) {
        String replace = start.replace("_", "");
        String replace1 = target.replace("_", "");
        if (!replace.equals(replace1)) {
            return false;
        }
        char[] chars = start.toCharArray();
        char[] chars1 = target.toCharArray();
        int i = 0, j = 0;
        while (i < chars.length && j < chars1.length) {
            if (chars[i] == chars1[j]) {
                i++;
                j++;
            } else {
                if (chars1[j] == '_') {
                    if (chars[i] == 'L' || i + 1 == chars.length) {
                        return false;
                    }
                    int tar = -1;
                    while (i < chars.length) {
                        if (chars[i] == '_') {
                            tar = i;
                            break;
                        } else if (chars[i] == 'L') {
                            return false;
                        }
                        i++;
                    }
                    char temp = chars[tar];
                    chars[tar] = chars[j];
                    chars[j] = temp;
                    i = j;
                } else if (chars1[j] == 'L') {
                    if (chars[i] == 'R') {
                        return false;
                    }
                    int tar = -1;
                    while (i < chars.length) {
                        if (chars[i] == 'L') {
                            tar = i;
                            break;
                        } else if (chars[i] == 'R') {
                            return false;
                        }
                        i++;
                    }
                    if (chars[i] == 'R') {
                        return false;
                    }
                    char temp = chars[tar];
                    chars[tar] = chars[j];
                    chars[j] = temp;
                    i = j;
                } else {
                    return false;
                }
            }
        }
        return i == j;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6114().canChange("_L__R__R_", "L______RR"));
    }
}
