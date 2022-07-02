package com.study.LeetCode501_600;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author jianghui
 * @date 2022-06-28 20:49
 */
public class LeetCode535 {

    private Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //生成一个8位的key
        String key = getRandomString(8);
        while (map.containsKey(key)) {
            key = getRandomString(8);
        }
        this.map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //拿到key
        int p = shortUrl.lastIndexOf('/') + 1;
        String key = shortUrl.substring(p);
        return map.get(key);
    }

    /**
     * 生成一个length长度的字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
