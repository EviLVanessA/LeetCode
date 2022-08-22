package com.study.LeetCode1601_1700;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/8/15
 */
public class LeetCode1656 {
    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}

class OrderedStream {

    private String[] data;
    private int ptr;

    public OrderedStream(int n) {
        data = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        data[idKey - 1] = value;
        List<String> ans = new ArrayList<>();
        while (ptr < data.length && data[ptr] != null) {
            ans.add(data[ptr]);
            ptr++;
        }
        return ans;
    }

}
