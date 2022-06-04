package com.study.LeetCode901_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-06-04 08:16
 */
public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            //找到@字符的位置
            int index = email.indexOf("@");
            //找到前缀
            String prefix = email.substring(0, index).split("\\+")[0].replace(".", "");
            //找到后缀
            String suffix = email.substring(index);
            ans.add(prefix + suffix);
        }
        return ans.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> ans = new HashSet<>();
        String match = "(?:\\.)(?=.*@)|(?:\\+.*)(?=@)";
        for (String email : emails) {
            String str = email.replace(match, "");
            ans.add(str);
        }
        return ans.size();
    }
}
