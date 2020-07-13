package com.q0017_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 * 时间复杂度 O(3^n)
 * 空间复杂度 O(len(n))
 */
public class Solution {


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

    //寻找digits[index]匹配的字母,获得digits[0...index]翻译得到的结
    private void findCombination(String digits, int index, String s) {
        System.out.println(index + " : " + s);
        if (index == digits.length()) {
            list.add(s);
            System.out.println("get " + s + ", return");
            return;
        }
        // '0' <= c <= '9'
        char c = digits.charAt(index);
        String letters = lettersMap[c - '0'];
        //abc
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c + ", use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits[" + index + "] = " + c + " complete,return ");

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.letterCombinations("23"));
    }
}
