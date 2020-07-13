package com.q0524_longest_word_in_dictionary_through_deleting;

import java.util.Arrays;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 524. 通过删除字母匹配到字典里最长单词
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = s;
        for (String str : d) {
            if (check(str, s)) {
                if (str.length() < res.length() && str.compareTo(res) < 0) {
                    res = str;
                }
            }
        }
        return res;
    }

    private boolean check(String s, String target) {
        if (s.length() > target.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
