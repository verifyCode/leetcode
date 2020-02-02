package com.q22_generate_parentheses;

import java.util.List;

/**
 * @author xjn
 * @since 2020-02-01
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 */
public class Solution {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, 1, "");
        return null;
    }

    private void generateParenthesis(int n, int start, String s) {
        if (n * 2 == s.length()) {
            System.out.println(s);
            return;
        }
        for (int i = start; i <= n; i++) {
            generateParenthesis(n, start, s + LEFT);
            generateParenthesis(n, start, s + RIGHT);
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.generateParenthesis(3);
    }

}
