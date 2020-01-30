package com.q17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-30
 */
public class Solution2 {

    String[] lettersMap = {
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

    private List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        findCombination(digits, 0, "");
        return list;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == s.length()) {
            list.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letter = lettersMap[c - '0'];
        for (int i = 0; i < letter.length(); i++) {
            findCombination(digits, index + 1, s + letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        test.letterCombinations("23");
    }
}