package com.q91_decode_ways;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjn
 * @since 2020-02-04
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 */
public class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return numDecodingsRecursive(s);
    }

    //返回字符串s的解码总数
    private int numDecodingsRecursive(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int w = numDecodingsRecursive(s.substring(1));
        String str = s.substring(0, 2);
        int temp = Integer.parseInt(str);
        if (temp <= 26) {
            w = w + numDecodingsRecursive(s.substring(2));
        }
        map.put(s, w);
        return w;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.numDecodings("12"));//2
        System.out.println(test.numDecodings("226"));//3
        System.out.println(test.numDecodings("12345"));//3
        System.out.println(test.numDecodings("00"));//0
        System.out.println(test.numDecodings("01"));//0
    }


}
