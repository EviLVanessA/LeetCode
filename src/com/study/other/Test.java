package com.study.other;

/**
 * @author jianghui
 * @date 2021-03-26 09:54
 */
public class Test {
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.get(3);
        lru.put(5,5);
        lru.put(6,5);
        lru.put(7,5);
        System.out.println(lru);
    }
}
