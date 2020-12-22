package com.study.leetcode1_100.leetcode51_75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-18 13:54
 */
public class LeetCode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < n) {
            List<String> curLine = new ArrayList<>();
            int curWidth = maxWidth + 1;
            int curWordsWidth = 0;
            while (i < n && words[i].length() + 1 <= curWidth) {
                curLine.add(words[i]);
                curWordsWidth += words[i].length() + 1;
                curWidth -= words[i].length() + 1;
                i++;
            }
            if (i != n){
                int remain = maxWidth - curWordsWidth + 1;
                int blank, last;
                StringBuilder s = new StringBuilder();
                if (curLine.size() > 1) {
                    blank = remain / (curLine.size() - 1);
                    last = remain % (curLine.size() - 1);
                    for (int j = 0; j < curLine.size(); j++) {
                        s.append(curLine.get(j));
                        if (j < curLine.size() - 2) {
                            int flag = last > 0 ? 1 : 0;
                            for (int k = 0; k <= blank + flag; k++) {
                                s.append(" ");
                            }
                            last--;
                        } else if (j == curLine.size() - 2) {
                            for (int k = 0; k <= blank; k++) {
                                s.append(" ");
                            }
                        }
                    }
                } else {
                    blank = remain;
                    s.append(curLine.get(0));
                    for (int k = 0; k < blank; k++) {
                        s.append(" ");
                    }
                }
                ans.add(s.toString());
            }else {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < curLine.size(); j++) {
                    s.append(curLine.get(j));
                    if (j < curLine.size()-1){
                        s.append(" ");
                    }
                }
                if (s.toString().length() < maxWidth){
                    int blank = maxWidth - s.toString().length();
                    for (int j = 0; j < blank ; j++) {
                        s.append(" ");
                    }
                }
                ans.add(s.toString());
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = new LeetCode68().fullJustify(words, 20);
        for (String str : list) {
            System.out.println(str);
        }
    }
}

