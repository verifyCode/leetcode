package com.q91_decode_ways;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjn
 * @since 2020-02-04
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int numDecodings(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        map.clear();
        return numDecodingsRecursive(s, 0);
    }

    //返回字符串s的解码总数
    private int numDecodingsRecursive(String s, int start) {
//        if (map.containsKey(start)) {
//            return map.get(start);
//        }
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }

        int a = numDecodingsRecursive(s, start + 1);
        int b = 0;
        if (start < s.length() - 1) {
            int ten = Integer.parseInt(s.charAt(start) + "") * 10;
            int ge = Integer.parseInt(s.charAt(start + 1) + "");
            if (ten + ge <= 26) {
                b = numDecodingsRecursive(s, start + 2);
            }
        }
//        map.put(start, a + b);
        return a + b;
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
