package com.q0784_letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-01
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * 784. 字母大小写全排列
 */
public class Solution {

    private List<String> resList = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        resList.clear();
        if (s == null || s.length() == 0) {
            return resList;
        }
        letterCasePermutation(s, 0, "");
        return resList;
    }

    private void letterCasePermutation(String s, int index, String str) {
        if (index == s.length()) {
            resList.add(str);
            return;
        }
        char c = s.charAt(index);
        if (Character.isAlphabetic(c)) {
            letterCasePermutation(s, index + 1, str + Character.toLowerCase(c));
            letterCasePermutation(s, index + 1, str + Character.toUpperCase(c));
        } else {
            letterCasePermutation(s, index + 1, str + c);
        }
        return;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.letterCasePermutation("a1b2"));
        System.out.println(test.letterCasePermutation("3z4"));
        System.out.println(test.letterCasePermutation("12345"));
    }
}
