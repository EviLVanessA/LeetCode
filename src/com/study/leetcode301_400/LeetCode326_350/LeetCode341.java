package com.study.leetcode301_400.LeetCode326_350;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/7/20
 */
public class LeetCode341 {

}

class NestedIterator implements Iterator<Integer> {

    List<Integer> data = new ArrayList<>();
    Iterator<Integer> iterator;


    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        iterator = data.iterator();
    }

    public void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                data.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
