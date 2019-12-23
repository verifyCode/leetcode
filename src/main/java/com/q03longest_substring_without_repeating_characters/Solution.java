package com.q03longest_substring_without_repeating_characters;

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
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        //滑动窗口
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int max = 0;
        while (r + 1 < s.length()) {
            if ((r + 1) < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                l++;
                freq[s.charAt(l)]--;
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(test.lengthOfLongestSubstring("pwewwwe"));
//        System.out.println(test.lengthOfLongestSubstring(""));

    }
}
