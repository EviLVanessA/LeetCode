package com.study.LeetCode1501_1600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/9/7
 */
public class LeetCode1592 {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int cntBlank = text.length();
        for (String word : words) {
            cntBlank -= word.length();
        }

        StringBuilder ans = new StringBuilder();
        if (words.length == 1) {
            ans.append(words[0]);
            for (int i = 0; i < cntBlank; i++) {
                ans.append(' ');
            }
            return ans.toString();
        }
        int avgBlank = cntBlank / (words.length - 1);
        int remainerBlank = cntBlank % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                for (int j = 0; j < avgBlank; j++) {
                    ans.append(' ');
                }
            }
            ans.append(words[i]);
        }
        for (int i = 0; i < remainerBlank; i++) {
            ans.append(' ');
        }
        return ans.toString();
    }

}
