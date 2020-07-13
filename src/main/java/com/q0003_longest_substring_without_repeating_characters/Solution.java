package com.q0003_longest_substring_without_repeating_characters;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @author xjn
 * @since 2019-12-23
 * 时间复杂度O(len(s))
 * 空间复杂度O(len(charset))
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new TreeSet<>();
        int l = 0;
        int r = 0;
        int size = 0;
        while (l < s.length() && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                size = Math.max(set.size(), r - l + 1);
            } else {
                l++;
                set.remove(s.charAt(l));
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("pwewwwe"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));

    }
}
