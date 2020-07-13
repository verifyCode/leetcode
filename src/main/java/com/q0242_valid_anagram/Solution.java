package com.q0242_valid_anagram;

/**
 * @author xjn
 * @since 2020-01-21
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            if (freq[t.charAt(i)] == 0) {
                return false;
            } else {
                freq[t.charAt(i)] -= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.isAnagram("anagram", "nagaram"));
        System.out.println(test.isAnagram("rat", "car"));
    }
}
