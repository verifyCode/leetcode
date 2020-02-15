package com.q17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-30
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 *
 * 时间复杂度O(3^n)
 * 空间复杂度O(3^n)
 */
public class Solution2 {
    private String[] letterMap = new String[]{
            " ",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9
    };

    private List<String> resList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        resList.clear();
        if (digits == null || digits.length() == 0) {
            return resList;
        }
        dfs(digits, 0, "");
        return resList;
    }

    private void dfs(String digits, int index, String s) {
        if (index == digits.length()) {
            resList.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letter = letterMap[c - '0'];
        for (int i = 0; i < letter.length(); i++) {
            dfs(digits, index + 1, s + letter.charAt(i));
        }
    }


    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.letterCombinations("23"));
    }
}