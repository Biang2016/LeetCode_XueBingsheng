package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by biang on 2017/5/11.
 */
public class Medium_535_EncodeAndDecodeTinyURL {

    public static void main(String args[]) {
        System.out.println(decode(encode("https://leetcode.com/problems/design-tinyurl")));
        System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
    }

    static Map<String, String> index = new HashMap<>();
    static Map<String, String> revIndex = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        if (revIndex.containsKey(longUrl)) return revIndex.get(longUrl);
        int begin = longUrl.indexOf(".com/");
        String website = longUrl.substring(0, begin + 5);
        String ori = longUrl.substring(begin + 5);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        return website + key;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        int begin = shortUrl.indexOf(".com/");
        String website = shortUrl.substring(0, begin + 5);
        String shortU = shortUrl.substring(begin + 5);
        return index.get(shortU);
    }
}
